package com.stt.dto.accountOpen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 上海易精灵开户出参Dto
 * Created by BF100177 on 2017/1/19.
 */
public class ShbyjlAccountOpenResDto implements Serializable{

    private String idNo;//证件号码(组织机构代码)
    private String eAcctNo;//对公电子户账号(上海银行行系统为客户生成的对公电子户账号)
    private String eAcctName;//对公电子户户名(对公电子户户名, 为用户的客户名称全称)
    private String custNo;//客户号(在上海银行客户管理系统中的客户号)
    private String subBranchNo;//开户归属支行号
    private String subBranchName;//开户归属支行名称
    private BigDecimal amount;//打款激活金额
    private Date actiDeadline;//客户打款激活的最后日期(YYYYMMD)
    private String docuOpNo;//制单员号
    private String checkerNo;//复核员号

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String geteAcctNo() {
        return eAcctNo;
    }

    public void seteAcctNo(String eAcctNo) {
        this.eAcctNo = eAcctNo;
    }

    public String geteAcctName() {
        return eAcctName;
    }

    public void seteAcctName(String eAcctName) {
        this.eAcctName = eAcctName;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getSubBranchNo() {
        return subBranchNo;
    }

    public void setSubBranchNo(String subBranchNo) {
        this.subBranchNo = subBranchNo;
    }

    public String getSubBranchName() {
        return subBranchName;
    }

    public void setSubBranchName(String subBranchName) {
        this.subBranchName = subBranchName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getActiDeadline() {
        return actiDeadline;
    }

    public void setActiDeadline(Date actiDeadline) {
        this.actiDeadline = actiDeadline;
    }

    public String getDocuOpNo() {
        return docuOpNo;
    }

    public void setDocuOpNo(String docuOpNo) {
        this.docuOpNo = docuOpNo;
    }

    public String getCheckerNo() {
        return checkerNo;
    }

    public void setCheckerNo(String checkerNo) {
        this.checkerNo = checkerNo;
    }
}
