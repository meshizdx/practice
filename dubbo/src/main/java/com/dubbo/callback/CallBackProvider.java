package com.dubbo.callback;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-09 10:38
 **/
public class CallBackProvider {

    public static void main(String[] args) throws Exception {
        String config = CallBackProvider.class.getPackage().getName().replace('.', '/') + "/callback-provider.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }
}
