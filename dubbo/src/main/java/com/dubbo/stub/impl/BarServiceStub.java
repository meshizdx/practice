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
 * @create by shaott at 2017-06-09 14:31
 **/
public class BarServiceStub implements BarService {

    private  BarService barService;

    public BarServiceStub(BarService barService){
        this.barService = barService;
    }

    @Override
    public String sayHell(String name) {
        // 此代码在客户端执行
        // 你可以在客户端做ThreadLocal本地缓存，或预先验证参数是否合法，等等


        try{
           return  barService.sayHell(name);
        }catch (Exception e){
            return "容错数据";
        }
    }


    public Response<ShbyjlAccountQueryResDto> query(Request<ShbyjlAccountQueryReqDto> request){
        if(request.getParam().getUserId().equals("110511124")){
            return FacadeFactory.createFailedResponseT(new ShbyjlAccountQueryResDto(),"10001","用户异常");
        }
        try{
            return barService.query(request);
        }catch (Exception e){
            return FacadeFactory.createFailedResponseT(new ShbyjlAccountQueryResDto(),"10001","系统异常");
        }
    }
}
