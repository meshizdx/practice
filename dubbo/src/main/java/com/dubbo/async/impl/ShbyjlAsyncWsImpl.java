package com.dubbo.async.impl;

import com.dubbo.common.IShbyjlAsyncWs;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.FacadeFactory;
import com.dubbo.common.facade.Request;
import com.dubbo.common.facade.Response;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-14 10:50
 **/
public class ShbyjlAsyncWsImpl implements IShbyjlAsyncWs {
    @Override
    public Response<ShbyjlAccountQueryResDto> async1(Request<ShbyjlAccountQueryReqDto> request) {
        long begTime = System.currentTimeMillis();
        ShbyjlAccountQueryResDto resDto = new ShbyjlAccountQueryResDto();
        resDto.setData("111：  异步方法1返回");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行时间"+(System.currentTimeMillis()-begTime));
        return FacadeFactory.createOkResponse(resDto);
    }

    @Override
    public Response<ShbyjlAccountQueryResDto> async2(Request<ShbyjlAccountQueryReqDto> request) {
        return null;
    }
}
