package com.dubbo.common.dto.accountOrderDirectiveQuery;

import java.io.Serializable;

/**
 * 对公电子户_交易指令状态查询
 * Created by BF100252 on 2017/2/23.
 */
public class ShbyjlAccountDirectiveQueryResDto implements Serializable {

    private String resultCode;//查询结果代码

    private String resultDesc;//交易结果描述

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }
}
