package com.dubbo.common;




import com.dubbo.callback.api.CallBackListener;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.Request;
import com.dubbo.common.facade.Response;

import java.util.List;

/**
 * 对公电子账户借口
 * Created by BF100252 on 2017/1/20.
 */
public interface IShbyjlAccountWs {


    /**
     * 服务分组
     */
   Response<ShbyjlAccountQueryResDto> query(Request<ShbyjlAccountQueryReqDto> request);

    /**
     * 服务分组+分组合并实例1
     * @return
     */
    List<String> mergeResult();


    /**
     * 服务分组+分组合并实例2
     */
    Response<List<ShbyjlAccountQueryResDto>> queryList(Request<ShbyjlAccountQueryReqDto> request);


    /**
     * 缓存
     */
    Response<ShbyjlAccountQueryResDto> cache(Request<ShbyjlAccountQueryReqDto> request);


    /**
     * 接口回调
     */
    Response<ShbyjlAccountQueryResDto> callback(Request<ShbyjlAccountQueryReqDto> request, CallBackListener listener);
}
