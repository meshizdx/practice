package com.dubbo.group;

import com.alibaba.fastjson.JSON;
import com.dubbo.cache.LruCacheConsumer;
import com.dubbo.group.api.IShbyjlAccountWs;
import com.dubbo.group.api.ShbyjlAccountQueryResDto;
import com.dubbo.group.facade.Response;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-08 9:34
 **/
public class GroupMergerConsumer {
    public static void main(String[] args) throws Exception {
        String config = GroupMergerConsumer.class.getPackage().getName().replace('.', '/') + "/group-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();

        IShbyjlAccountWs shbyjlAccountWs  = (IShbyjlAccountWs)context.getBean("shbyjlAccountWsImpl");
        Response<List<ShbyjlAccountQueryResDto>> response =shbyjlAccountWs.queryList(null);
        System.out.println(JSON.toJSONString(response.getResult()));
    }

}
