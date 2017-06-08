package com.dubbo.cache.impl;

import com.dubbo.cache.api.CacheService;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-06 10:31
 **/
public class CacheServiceImpl implements CacheService {

    private final AtomicInteger i = new AtomicInteger();

    @Override
    public String findCache(String id) {
        int j  = i.getAndIncrement();
        System.out.println(  "1111   server :          request: " + id + ", response: " + j);
        return "request: " + id + ", response: " + j;
    }
}
