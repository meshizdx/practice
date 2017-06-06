package com.yyj.demo.activiti.support;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.utils.ReferenceConfigCache;
import com.alibaba.dubbo.rpc.service.GenericService;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * Created by Administrator on 2017/5/5.
 */
@Slf4j
public class DubboUtil {
    private static Properties prop;
    private static ApplicationConfig application;// 当前应用配置
    private static RegistryConfig registry;// 连接注册中心配置
    private static ReferenceConfigCache cache = ReferenceConfigCache.getCache();

    static {
        try {
            prop = new Properties();
            ClassLoader classLoader = DubboUtil.class.getClassLoader();
            prop.load(classLoader.getResourceAsStream("dubbo.properties"));

            application = new ApplicationConfig();
            application.setName(prop.getProperty("dubbo.application.name"));

            registry = new RegistryConfig();
            registry.setAddress(prop.getProperty("dubbo.registry.address"));
            registry.setProtocol(prop.getProperty("dubbo.registry.protocol"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object excute(DubboServiceDTO serviceDTO) throws Exception {
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();// 引用远程服务
        reference.setApplication(application);
        reference.setRegistry(registry);
        reference.setGeneric(true); // 声明为泛化接口

        reference.setInterface(serviceDTO.getInterfaceName()); // 弱类型接口名
        reference.setVersion(serviceDTO.getVersion());

        GenericService genericService = null;
        try {
            genericService = cache.get(reference);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (genericService == null) {
                log.info("DubboService Execute>>>{}<<<{}", serviceDTO, null);
                return null;
            }
        }

        // 基本类型以及Date,List,Map等不需要转换，直接调用
        Object result = genericService.$invoke(serviceDTO.getMethodName(), serviceDTO.getParameterTypes(), serviceDTO.getParameters());
        log.info("DubboService Execute>>>{}<<<{}", serviceDTO, result);
        return result;
    }
}
