package com.spring.boot.web.enums;

/**
 * Created by BF100177 on 2017/5/27.
 */
public enum ResultCode {

    /** 成功 */
    SUCCESS("200", "成功"),


    /** 发生异常 */
    EXCEPTION("401", "发生异常"),

    /** 系统错误 */
    SYS_ERROR("402", "系统错误"),

    /** 参数错误 */
    PARAMS_ERROR("403", "参数错误 ")

    ;

    private ResultCode(String value, String msg){
        this.val = value;
        this.msg = msg;
    }

    public String val() {
        return val;
    }

    public String msg() {
        return msg;
    }

    private String val;
    private String msg;

    }
