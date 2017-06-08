package com.dubbo.balance.server1.impl;

import com.dubbo.balance.api.IBalanceServer;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-08 10:41
 **/
public class BalanceServerImpl1 implements IBalanceServer {
    @Override
    public String balance(Integer balanceId) {
        System.out.println("server 1 "+ balanceId);
        return "server 1";
    }
}
