package com.dubbo.concurrentcontrol.impl;

import com.dubbo.concurrentcontrol.api.IExecutesService;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-14 16:17
 **/
public class IExecutesServiceImpl implements IExecutesService {

    @Override
    public void execute() {
        System.out.println(Thread.currentThread().getName()+"     begin running   ");
        try {
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName()+"     end running   ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

