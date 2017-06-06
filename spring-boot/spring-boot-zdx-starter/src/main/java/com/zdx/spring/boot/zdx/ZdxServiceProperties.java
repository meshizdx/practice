package com.zdx.spring.boot.zdx;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 属性配置类
 * Created by BF100177 on 2017/5/25.
 */
@ConfigurationProperties(prefix = "zdx")
public class ZdxServiceProperties {

    private static final String MSG = "I'm ZDX ！";

    private String msg = MSG;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
