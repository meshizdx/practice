package com.dubbo.group.facade;



import java.util.Date;
import java.util.UUID;

/**
 * 创建请求、返回对象工厂方法
 *
 * Created by wjg on 2016/11/22.
 */
public class FacadeFactory {
    /**
     * 创建请求对象
     * @param requestSysCode
     * @param traceLogNo
     * @return
     */
    public static Request createRequest(String requestSysCode, String traceLogNo) {
        return createRequest(requestSysCode, traceLogNo, null);
    }

    /**
     * 创建请求对象
     * @param requestSysCode
     * @param traceLogNo
     * @param param
     * @param <T>
     * @return
     */
    public static <T> Request<T> createRequest(String requestSysCode, String traceLogNo, T param) {
        Request<T> request = new Request<T>();
        String uuid = UUID.randomUUID().toString();
        request.setRequestNo(uuid.replace("-", ""));
        request.setRequestSysCode(requestSysCode);
        request.setRequestTime(new Date());
        request.setTraceLogNo(traceLogNo);
        request.setParam(param);
        return request;
    }

    /**
     * 创建成功结果
     * @return
     */
    public static Response createOkResponse() {
        return createResponse(true, null, null, null);
    }

    /**
     * 创建成功结果
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Response<T> createOkResponse(T obj) {
        return createResponse(true, obj, null, null);
    }


    /**
     * 创建失败结果
     * @param errorCode
     * @param errorMsg
     * @param args
     * @param <T>
     * @return
     */
    public static <T> Response<T> createFailedResponse(String errorCode, String errorMsg, Object ... args) {
        return createResponse(false, null, errorCode, errorMsg, args);
    }

    /**
     * 创建失败结果
     * @param errorCode
     * @param errorMsg
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> Response<T> createFailedResponseT(T obj,String errorCode, String errorMsg, Object ... args) {
        return createResponse(false, obj, errorCode, errorMsg, args);
    }





    /**
     * 创建返回结果
     * @param isSuccess 是否成功
     * @param obj 业务返回对象
     * @param errorCode 错误码
     * @param errorMsg 错误信息
     * @param args 错误信息中的参数
     * @param <T>
     * @return
     */
    public static <T> Response<T> createResponse(boolean isSuccess, T obj, String errorCode, String errorMsg, Object ... args) {
        String msg = errorMsg;
        if (null != args && args.length > 0 && null != errorMsg) {
            msg = String.format(errorMsg, args);
        }
        return new Response<T>(isSuccess, obj, errorCode, msg);
    }
}
