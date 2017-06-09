package com.stt.dto.accountTradeQuery;


import java.io.Serializable;
import java.util.Date;


/**
 * Created by BF100252 on 2017/2/23.
 */
public class ShbyjlAccountTradeQueryReqDto implements Serializable{



    private String userId;//用户ID


    private String eAcctNo;//对公电子账号


    private Date startDate;//查询条件的开始日期(yyyyMMdd)


    private Date endDate;//查询条件的结束日期(yyyyMMdd)

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
