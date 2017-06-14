package com.dubbo.common;

import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.Request;
import com.dubbo.common.facade.Response;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-14 10:49
 **/
public interface IShbyjlAsyncWs2 {

    /**
     * 异步访问1
     */
    Response<ShbyjlAccountQueryResDto> async1(Request<ShbyjlAccountQueryReqDto> request);


    /**
     * 异步访问2
     */
    Response<ShbyjlAccountQueryResDto> async2(Request<ShbyjlAccountQueryReqDto> request);
}
