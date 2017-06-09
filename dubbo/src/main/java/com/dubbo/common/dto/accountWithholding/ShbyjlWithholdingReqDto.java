package com.dubbo.common.dto.accountWithholding;




import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by BF100177 on 2017/1/26.
 */
public class ShbyjlWithholdingReqDto implements Serializable{


    private String userId;//漫道内部用户ID


    private String eAcctNo;//对公电子户账号


    private String chargeCode;//代扣产品代码


    private BigDecimal amount;//代扣金额


    private String channelFlowNo;//第三方平台流水号//不能重复

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

    public String getChargeCode() {
        return chargeCode;
    }

    public void setChargeCode(String chargeCode) {
        this.chargeCode = chargeCode;
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
