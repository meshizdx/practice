package com.dubbo.balance.consumer;

import com.dubbo.balance.api.IBalanceServer;
import com.dubbo.cache.LruCacheConsumer;
import com.dubbo.cache.api.CacheService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-08 10:46
 **/
public class BalanceConsumerApplication {

    public static void main(String[] args) throws Exception {
        String config = BalanceConsumerApplication.class.getPackage().getName().replace('.', '/') + "/balance-consumer1.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();

        IBalanceServer balanceServer = (IBalanceServer)context.getBean("balanceServer");

        // 测试缓存生效，多次调用返回同样的结果。(服务器端自增长返回值)
        //预期每次请求的值完全一致
        List<String> list = new ArrayList<String>();
        List<String> serverList1 = new ArrayList<String>();
        List<String> serverList2 = new ArrayList<String>();
        List<String> serverList3 = new ArrayList<String>();
        for (int i = 0; i < 30; i ++) {
            for(int n = 0 ; n < 3 ; n++){
                String result = balanceServer.balance(n);
                list.add(result);
                if(result.equals("server 1")){
                    serverList1.add(result);
                }

                if(result.equals("server 2")){
                    serverList2.add(result);
                }

                if(result.equals("server 3")){
                    serverList3.add(result);
                }

                System.out.println(result);
            }
        }

        System.out.println(" 总调用次数 ："+ list.size() +"\n"+"服务一调用次数 ："+ serverList1.size()+
                "\n"+"服务二调用次数 ："+ serverList2.size()+"\n"+"服务三调用次数 ："+ serverList3.size());
    }
}
