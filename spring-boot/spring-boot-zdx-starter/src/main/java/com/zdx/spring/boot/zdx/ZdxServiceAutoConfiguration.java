package com.zdx.spring.boot.zdx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by BF100177 on 2017/5/25.
 */
@Configuration
// @EnableConfigurationProperties 把配置文件自动封装成实体类
@EnableConfigurationProperties(ZdxServiceProperties.class)
// @ConditionalOnClass 判断类是否在路径中存在
@ConditionalOnClass(ZdxService.class)
// @ConditionalOnProperty 判断指定属性是否有指定的值
@ConditionalOnProperty(prefix = "zdx",value = "enabled",matchIfMissing = true)
public class ZdxServiceAutoConfiguration {

    @Autowired
    private ZdxServiceProperties zdxServiceProperties;

    @Bean
    // @ConditionalOnMissingBean 当容器里没有指定 Bean的情况下
    @ConditionalOnMissingBean(ZdxService.class)
    public ZdxService zdxService(){
        ZdxService zdxService = new ZdxService();
        zdxService.setMsg(zdxServiceProperties.getMsg());
        return zdxService;
    }

}
