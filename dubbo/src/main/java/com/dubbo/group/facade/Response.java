package com.dubbo.group.facade;

import java.io.Serializable;

/**
 * dubbo接口统一返回结果
 * 使用isSuccess判断调用是否成功 ,如果为true,则可以调用getResult,如果为false,则调用errorCode来获取出错信息
 * <p>
 * 1、isSuccess         判断调用是否成功
 * 2、getResult         获取调用结果集
 * 3、setResult         设置调用结果集
 * 4、getErrorCode      获取错误码
 * 5、setErrorCode      设置错误码
 * 6、getErrorMsg       获取错误描述
 * 7、setErrorMsg       设置错误描述
 * </p>
 * User: MuZhi Date:2015/10/14
 */
public class Response<T> implements Serializable {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 2481500502307792394L;

    /**
     * 接口调用状态-如果为true,则可以调用getResult,如果为false,则调用errorCode来获取出错信息
     */
    private boolean success;

    /**
     * 调用返回值-泛型
     */
    private T result;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMsg;

    /**
     * 默认构造方法
     */
    public Response() {
    }

    /**
     * 构造方法
     * @param success
     * @param result
     * @param errorCode
     * @param errorMsg
     */
    public Response(boolean success, T result, String errorCode, String errorMsg) {
        this.success = success;
        this.result = result;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T body) {
        success = true;
        this.result = body;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.success = false;
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Response response = (Response) o;

        return success == response.success
                && result.equals(response.result)
                && errorCode.equals(response.errorCode);

    }

    @Override
    public int hashCode() {
        int result1 = (success ? 1 : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        result1 = 31 * result1 + (errorCode != null ? errorCode.hashCode() : 0);
        result1 = 31 * result1 + (errorMsg != null ? errorMsg.hashCode() : 0);
        return result1;
    }
}
