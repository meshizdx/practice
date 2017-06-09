package com.stt.dto.accountWithholding;

import java.io.Serializable;

/**
 * Created by BF100177 on 2017/1/26.
 */
public class ShbyjlWithholdingResDto implements Serializable{

    private String flowNo;//银行流水号

    public String getFlowNo() {
        return flowNo;
    }

    public void setFlowNo(String flowNo) {
        this.flowNo = flowNo;
    }
}
