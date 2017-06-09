package com.stt.dto.account;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by BF100177 on 2017/1/25.
 */
public class ShyjlAccountActivateResDto implements Serializable{
    private BigDecimal amount;//客户打款激活金额

    private Date actiDeadline;//客户打款激活最后日期

    //对公电子户状态代码
    public static final String EACCT_STATE_YES = "00000000";//已经激活
    public static final String EACCT_STATE_FAIL = "00000001";//未激活

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

    public static String getEacctStateYes() {
        return EACCT_STATE_YES;
    }

    public static String getEacctStateFail() {
        return EACCT_STATE_FAIL;
    }
}
