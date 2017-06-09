package com.stt.dto.account;



import java.io.Serializable;

/**
 * Created by BF100177 on 2017/1/25.
 */
public class ShyjlAccountActivateReqDto implements Serializable{


    private String userId;//漫道内部用户ID

    private String eAcctNo;//上海银行为客户生成的对公电子户账号

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
}
