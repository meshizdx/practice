package com.dubbo.event_notify;

import com.alibaba.fastjson.JSON;
import com.dubbo.common.IShbyjlAccountWs;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.FacadeFactory;
import com.dubbo.common.facade.Response;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 * <p>
 * Description:
 * Created by Admin on 2017/6/11.
 */
public class EventNotifyConsumer {

    public static void main(String[] args) {
        String config = EventNotifyConsumer.class.getPackage().getName().replace('.', '/') + "/eventnotify-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();

        IShbyjlAccountWs shbyjlAccountWs = (IShbyjlAccountWs)context.getBean("shbyjlAccountWsImpl");
        Response<ShbyjlAccountQueryResDto> resDtoResponse =  shbyjlAccountWs.query(FacadeFactory.createRequest("",""));
        System.out.println(JSON.toJSON(resDtoResponse));
    }
}
