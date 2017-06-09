package com.stt.facade;

/**
 * 接口返回工具类
 *
 * @author wjg
 * @date 2016/12/26.
 */
public class ResponseUtil {
    /**
     * 判断返回是否成功
     *
     * @param response
     * @return
     */
    public static boolean isSuccess(Response response) {
        return response != null && response.isSuccess();
    }
}
