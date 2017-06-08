package com.dubbo.group.api;




import com.dubbo.group.facade.Request;
import com.dubbo.group.facade.Response;

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

}
