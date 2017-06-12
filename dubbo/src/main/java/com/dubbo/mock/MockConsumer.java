package com.dubbo.mock;

import com.alibaba.fastjson.JSON;
import com.dubbo.common.IShbyjlAccountWs;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;

import com.dubbo.common.facade.Response;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-09 17:10
 **/
public class MockConsumer {

    public static void main(String[] args) throws Exception {
        String config = MockConsumer.class.getPackage().getName().replace('.', '/') + "/mock-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();

        IShbyjlAccountWs shbyjlAccountWs  = (IShbyjlAccountWs)context.getBean("mockServiceImpl");
        System.out.println("MockConsumer begin");
        Response<ShbyjlAccountQueryResDto> response =shbyjlAccountWs.mock(null);
        System.out.println(JSON.toJSONString(response.getResult()));
        System.in.read();
    }
}
