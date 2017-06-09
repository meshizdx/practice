package com.dubbo.stub.api;

import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.Request;
import com.dubbo.common.facade.Response;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @author shaott
 * @create 2017-06-09 14:29
 **/
public interface BarService {

    public String sayHell(String name);

    Response<ShbyjlAccountQueryResDto> query(Request<ShbyjlAccountQueryReqDto> request);
}
