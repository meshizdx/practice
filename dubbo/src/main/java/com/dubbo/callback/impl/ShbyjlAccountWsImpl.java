package com.dubbo.callback.impl;

import com.dubbo.callback.api.CallBackListener;
import com.dubbo.common.IShbyjlAccountWs;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.Request;
import com.dubbo.common.facade.Response;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-09 13:33
 **/
public class ShbyjlAccountWsImpl implements IShbyjlAccountWs {
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
        for(int i=0;i<100;i++){
            listener.changed("Changed: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
