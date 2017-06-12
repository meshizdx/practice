package com.dubbo.event_notify.impl;

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
 * <p>
 * Description:
 * Created by Admin on 2017/6/11.
 */
public class ShbyjlAccountWsImpl implements IShbyjlAccountWs {
    public Response<ShbyjlAccountQueryResDto> query(Request<ShbyjlAccountQueryReqDto> request) {
        if(request == null){
            System.out.println("参数为空，异常返回");
            throw new IllegalArgumentException("入参为空");
        }
        ShbyjlAccountQueryResDto resDto = new ShbyjlAccountQueryResDto();
        resDto.setData("==== dto");
        return FacadeFactory.createOkResponse(resDto);
    }

    public List<String> mergeResult() {
        return null;
    }

    public Response<List<ShbyjlAccountQueryResDto>> queryList(Request<ShbyjlAccountQueryReqDto> request) {
        return null;
    }

    public Response<ShbyjlAccountQueryResDto> cache(Request<ShbyjlAccountQueryReqDto> request) {
        return null;
    }

    public Response<ShbyjlAccountQueryResDto> callback(Request<ShbyjlAccountQueryReqDto> request, CallBackListener listener) {
        return null;
    }

    @Override
    public Response<ShbyjlAccountQueryResDto> mock(Request<ShbyjlAccountQueryReqDto> request) {
        return null;
    }
}
