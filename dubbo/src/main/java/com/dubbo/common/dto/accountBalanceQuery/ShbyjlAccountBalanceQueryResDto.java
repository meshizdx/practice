package com.stt.dto.accountBalanceQuery;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by BF100252 on 2017/2/23.
 */
public class ShbyjlAccountBalanceQueryResDto implements Serializable{

    private BigDecimal amount;//对公电子户余额金额，单位为元

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
