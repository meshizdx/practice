package com.dubbo.common.facade;


import java.io.Serializable;
import java.util.Date;

/**
 * 请求对象基类
 *
 * Created by wjg on 2016/11/22.
 */
public class Request<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 请求流水号
     */

    private String requestNo;

    /**
     * 请求系统名称
     */

    private String requestSysCode;

    /**
     * 请求时间
     */

    private Date requestTime;

    /**
     * 业务流水号
     */

    private String traceLogNo;

    /**
     * 请求业务对象
     */
    private T param;

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    public String getRequestSysCode() {
        return requestSysCode;
    }

    public void setRequestSysCode(String requestSysCode) {
        this.requestSysCode = requestSysCode;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getTraceLogNo() {
        return traceLogNo;
    }

    public void setTraceLogNo(String traceLogNo) {
        this.traceLogNo = traceLogNo;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}
