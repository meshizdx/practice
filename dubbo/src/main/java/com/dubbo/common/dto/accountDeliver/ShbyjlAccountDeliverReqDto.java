package com.stt.dto.accountDeliver;


import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by BF100252 on 2017/2/7.
 */
public class ShbyjlAccountDeliverReqDto implements Serializable {


    private String userId;//漫道内部用户ID


    private String eAcctNo;//对公电子户账号


    private BigDecimal amount;//代扣金额


    private String channelFlowNo;//第三方平台流水号


    private String platformSummary;//平台摘要


    private String usage;//备注

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String geteAcctNo() {
        return eAcctNo;
    }

    public void seteAcctNo(String eAcctNo) {
        this.eAcctNo = eAcctNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getChannelFlowNo() {
        return channelFlowNo;
    }

    public void setChannelFlowNo(String channelFlowNo) {
        this.channelFlowNo = channelFlowNo;
    }

    public String getPlatformSummary() {
        return platformSummary;
    }

    public void setPlatformSummary(String platformSummary) {
        this.platformSummary = platformSummary;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
