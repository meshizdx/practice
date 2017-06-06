package com.zdx.spring.boot.zdx;

/**
 * 判断依据类
 * Created by BF100177 on 2017/5/25.
 */
public class ZdxService {

    private String msg;

    public String say(){
        return "say"+msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
