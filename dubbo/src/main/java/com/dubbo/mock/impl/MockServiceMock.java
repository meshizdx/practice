package com.dubbo.mock.impl;

import com.dubbo.callback.api.CallBackListener;
import com.dubbo.common.IShbyjlAccountWs;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.FacadeFactory;
import com.dubbo.common.facade.Request;
import com.dubbo.common.facade.Response;

import java.util.List;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-09 17:08
 **/
public class MockServiceMock implements IShbyjlAccountWs {
    @Override
    public Response<ShbyjlAccountQueryResDto> query(Request<ShbyjlAccountQueryReqDto> request) {
        return null;
    }

    @Override
    public List<String> mergeResult() {
        return null;
    }

    @Override
    public Response<List<ShbyjlAccountQueryResDto>> queryList(Request<ShbyjlAccountQueryReqDto> request) {
        return null;
    }

    @Override
    public Response<ShbyjlAccountQueryResDto> cache(Request<ShbyjlAccountQueryReqDto> request) {
        return null;
    }

    @Override
    public Response<ShbyjlAccountQueryResDto> callback(Request<ShbyjlAccountQueryReqDto> request, CallBackListener listener) {
        return null;
    }

    @Override
    public Response<ShbyjlAccountQueryResDto> mock(Request<ShbyjlAccountQueryReqDto> request) {
        ShbyjlAccountQueryResDto resDto = new ShbyjlAccountQueryResDto();
        resDto.setData("mock伪装后的结果");
        return FacadeFactory.createOkResponse(resDto);
    }
}
