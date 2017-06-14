package com.dubbo.concurrentcontrol;

import com.alibaba.fastjson.JSON;
import com.dubbo.concurrentcontrol.api.IExecutesService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-14 16:31
 **/
public class ExecuteConsumer {

    static IExecutesService executesService = null;

    public static void main(String[] args) throws Exception{
        String config = ExecuteConsumer.class.getPackage().getName().replace('.', '/') + "/execute-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();

        executesService = (IExecutesService)context.getBean("executesServiceImpl");
        for(int i=0;i<10;i++){
            MyThread myThread = new MyThread();
            myThread.start();
        }

        System.in.read();
    }

  static  class MyThread extends Thread{
        final IExecutesService executesService1 = executesService;
        public void run(){
            executesService1.execute();
        }
    }

};


