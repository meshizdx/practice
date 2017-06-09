package com.stt.dto.accountDeliver;

import java.io.Serializable;

/**
 * Created by BF100252 on 2017/2/7.
 */
public class ShbyjlAccountDeliverResDto implements Serializable {

    private String flowNo;//银行流水号

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }
}
