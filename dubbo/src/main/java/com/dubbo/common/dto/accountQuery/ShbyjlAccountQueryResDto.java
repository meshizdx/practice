package com.dubbo.common.dto.accountQuery;

import java.io.Serializable;

/**
 * Created by BF100252 on 2017/1/20.
 */
public class ShbyjlAccountQueryResDto implements Serializable {

    private String data;//对公电子户状态代码  00000000 - 已经激活   00000001 - 未激活

    //对公电子户状态代码
    public static final String EACCT_STATE_YES = "00000000";//已经激活
    public static final String EACCT_STATE_FAIL = "00000001";//未激活

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
