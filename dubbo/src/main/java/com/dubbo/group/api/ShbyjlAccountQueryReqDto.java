package com.dubbo.group.api;



import java.io.Serializable;

/**
 * Created by BF100252 on 2017/1/20.
 */
public class ShbyjlAccountQueryReqDto implements Serializable {


    private String userId;//用户ID

    private String eAcctNo;//对公电子账号

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
