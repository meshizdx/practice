package com.stt.account;


import com.stt.dto.account.ShyjlAccountActivateReqDto;
import com.stt.dto.account.ShyjlAccountActivateResDto;
import com.stt.dto.accountBalanceQuery.ShbyjlAccountBalanceQueryReqDto;
import com.stt.dto.accountBalanceQuery.ShbyjlAccountBalanceQueryResDto;
import com.stt.dto.accountOpen.ShbyjlAccountOpenReqDto;
import com.stt.dto.accountOpen.ShbyjlAccountOpenResDto;
import com.stt.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.stt.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.stt.facade.Request;
import com.stt.facade.Response;

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
