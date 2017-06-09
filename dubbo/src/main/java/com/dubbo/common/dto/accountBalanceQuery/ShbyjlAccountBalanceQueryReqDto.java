package com.stt.dto.accountBalanceQuery;



import java.io.Serializable;

/**
 * Created by BF100252 on 2017/2/23.
 */
public class ShbyjlAccountBalanceQueryReqDto implements Serializable {


    private String userId;//漫道内部用户ID


    private String eAcctNo;//对公电子户账号

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
