package com.dubbo.common.dto.accountOrderDirectiveQuery;

import java.io.Serializable;

/**
 * 对公电子户_交易指令状态查询
 * Created by BF100252 on 2017/2/23.
 */
public class ShbyjlAccountDirectiveQueryReqDto implements Serializable{

    private String userId;//漫道内部用户ID

    private String channelFlowNo;//第三方平台提供的流水号,和银行提供的流水号后续对账用

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getChannelFlowNo() {
        return channelFlowNo;
    }

    public void setChannelFlowNo(String channelFlowNo) {
        this.channelFlowNo = channelFlowNo;
    }
}
