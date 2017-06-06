package com.spring.boot.web.web;

import com.spring.boot.web.enums.ResultCode;

/**
 * Created by BF100177 on 2017/5/27.
 */
public class JsonResult {

    private String code;

    private String message;

    private Object data;

    public JsonResult() {
        this.setCode(ResultCode.SUCCESS.val());
        this.setMessage("成功！");

    }

    public JsonResult(ResultCode code) {
        this.setCode(code.val());
        this.setMessage(code.msg());
    }

    public JsonResult(ResultCode code, String message) {
        this.setCode(code.val());
        this.setMessage(message);
    }

    public JsonResult(ResultCode code, String message, Object data) {
        this.setCode(code.val());
        this.setMessage(message);
        this.setData(data);
    }

    public JsonResult(ResultCode code, Object data) {
        this.setCode(code.val());
        this.setMessage(code.msg());
        this.setData(data);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
