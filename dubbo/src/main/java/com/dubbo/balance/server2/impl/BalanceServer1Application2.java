package com.dubbo.balance.server2.impl;

import com.dubbo.cache.CacheProvider;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-08 10:46
 **/
public class BalanceServer1Application2 {
    public static void main(String[] args) throws Exception {
        String config = BalanceServer1Application2.class.getPackage().getName().replace('.', '/') + "/balance-server2.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        System.in.read();
    }

}
