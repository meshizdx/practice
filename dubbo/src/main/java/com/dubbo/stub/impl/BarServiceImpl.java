package com.dubbo.stub.impl;

import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.FacadeFactory;
import com.dubbo.common.facade.Request;
import com.dubbo.common.facade.Response;
import com.dubbo.stub.api.BarService;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-09 14:30
 **/
public class BarServiceImpl implements BarService {
    @Override
    public String sayHell(String name) {
        System.out.println("hello" +name);
        return "hello" +name;
    }

    public Response<ShbyjlAccountQueryResDto> query(Request<ShbyjlAccountQueryReqDto> request){
        ShbyjlAccountQueryResDto shbyjlAccountQueryResDto = new ShbyjlAccountQueryResDto();
        shbyjlAccountQueryResDto.setData("10000");
        return FacadeFactory.createOkResponse(shbyjlAccountQueryResDto);
    }
}
