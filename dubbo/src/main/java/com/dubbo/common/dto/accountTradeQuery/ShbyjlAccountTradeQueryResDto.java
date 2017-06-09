package com.dubbo.common.dto.accountTradeQuery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by BF100252 on 2017/2/23.
 */
public class ShbyjlAccountTradeQueryResDto implements Serializable {

    private Date txnDate;//转账交易发生的日期

    private Date txnTime;//转账交易发生的时间

    private String txnDrcr;//账务发生的方向  DEBIT:转出 CREDIT:转入

    private BigDecimal txnAmt;//账务发生的金额，单位为分

    private BigDecimal hisBal;//账务发生后的账户余额

    private String	desc;//	交易的描述信息

    private String	stmt;//STMT.ENTRY的ID

    private String	vouType;//交易的凭证类型

    private String	vouNo;//交易的凭证编号

    private String	oppAc;//交易对手方的账号

    private String	oppacName;//交易对手方的户名

    private String	oppbrName;//交易对手方的行名

    private String	remark;//转账的备注信息

    private String	usage;//转账的用途信息

    public Date getTxnDate() {
        return txnDate;
    }

    public void setTxnDate(Date txnDate) {
        this.txnDate = txnDate;
    }

    public Date getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(Date txnTime) {
        this.txnTime = txnTime;
    }

    public String getTxnDrcr() {
        return txnDrcr;
    }

    public void setTxnDrcr(String txnDrcr) {
        this.txnDrcr = txnDrcr;
    }

    public BigDecimal getTxnAmt() {
        return txnAmt;
    }

    public void setTxnAmt(BigDecimal txnAmt) {
        this.txnAmt = txnAmt;
    }

    public BigDecimal getHisBal() {
        return hisBal;
    }

    public void setHisBal(BigDecimal hisBal) {
        this.hisBal = hisBal;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getStmt() {
        return stmt;
    }

    public void setStmt(String stmt) {
        this.stmt = stmt;
    }

    public String getVouType() {
        return vouType;
    }

    public void setVouType(String vouType) {
        this.vouType = vouType;
    }

    public String getVouNo() {
        return vouNo;
    }

    public void setVouNo(String vouNo) {
        this.vouNo = vouNo;
    }

    public String getOppAc() {
        return oppAc;
    }

    public void setOppAc(String oppAc) {
        this.oppAc = oppAc;
    }

    public String getOppacName() {
        return oppacName;
    }

    public void setOppacName(String oppacName) {
        this.oppacName = oppacName;
    }

    public String getOppbrName() {
        return oppbrName;
    }

    public void setOppbrName(String oppbrName) {
        this.oppbrName = oppbrName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }
}
