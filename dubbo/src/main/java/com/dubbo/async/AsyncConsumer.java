package com.dubbo.async;

import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.fastjson.JSON;
import com.dubbo.common.IShbyjlAsyncWs;
import com.dubbo.common.IShbyjlAsyncWs2;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.FacadeFactory;
import com.dubbo.common.facade.Response;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.Future;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-08 19:08
 **/
public class AsyncConsumer {


    public static void main(String[] args) throws Exception{
        String config = AsyncConsumer.class.getPackage().getName().replace('.', '/') + "/async-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();

        IShbyjlAsyncWs shbyjlAccountWsImpl = (IShbyjlAsyncWs)context.getBean("shbyjlAsyncWsImpl");
        shbyjlAccountWsImpl.async1(null);
        Future<Response<ShbyjlAccountQueryResDto>> pFuture = RpcContext.getContext().getFuture();
        System.out.println("当前服务配置信息1 ："+RpcContext.getContext().getUrl());
        System.out.println();

        IShbyjlAsyncWs2 shbyjlAccountWsImpl2 = (IShbyjlAsyncWs2)context.getBean("shbyjlAsyncWsImpl2");
        shbyjlAccountWsImpl2.async1(null);
        Future<Response<ShbyjlAccountQueryResDto>> pFuture2 = RpcContext.getContext().getFuture();
        System.out.println("当前服务配置信息2 ："+RpcContext.getContext().getUrl());

        Response<ShbyjlAccountQueryResDto> resDtoResponse2 = pFuture2.get();
        System.out.println("第二个返回： "+JSON.toJSON(resDtoResponse2));

        Response<ShbyjlAccountQueryResDto> resDtoResponse = pFuture.get();
        System.out.println("第一个返回： "+JSON.toJSON(resDtoResponse));
    }

}
