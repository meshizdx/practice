package com.dubbo.event_notify;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 * <p>
 * Description:
 * Created by Admin on 2017/6/11.
 */
public class EventNotifyProvider {

    public static void main(String[] args) throws Exception {
        String config = EventNotifyProvider.class.getPackage().getName().replace('.', '/') + "/eventnotify-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }
}
