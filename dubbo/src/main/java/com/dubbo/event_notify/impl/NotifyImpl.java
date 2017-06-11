package com.dubbo.event_notify.impl;

import com.dubbo.event_notify.api.INotify;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 * <p>
 * Description:
 * Created by Admin on 2017/6/11.
 */
public class NotifyImpl implements INotify {
    public void onreturn(Object res, Object... args) {
        System.out.println("返回值："+res);
        for (Object object : args) {
            System.out.println("参数："+object);
        }
    }

    public void onthrow(Throwable ex, Object... args) {
        System.out.println("异常："+ex.getMessage());
        for (Object object : args) {
            System.out.println("异常参数："+object);
        }
    }
}
