package com.dubbo.group.facade;

import com.alibaba.dubbo.rpc.cluster.Merger;
import com.dubbo.group.api.ShbyjlAccountQueryResDto;

import java.util.ArrayList;
import java.util.List;


/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-05 17:23
 **/
public class MyMerger implements Merger{


    @Override
    public Object merge(Object[] items) {
        Response<List<ShbyjlAccountQueryResDto>> result = new Response<List<ShbyjlAccountQueryResDto>>();
        List<ShbyjlAccountQueryResDto> list = new ArrayList<ShbyjlAccountQueryResDto>();
        for(Object obj:items){
            Response<List<ShbyjlAccountQueryResDto>> response = (Response<List<ShbyjlAccountQueryResDto>>)obj;
            List<ShbyjlAccountQueryResDto> list1 = response.getResult();
            list.addAll(list1);
        }
        result.setResult(list);
        return result;
    }
}
