package com.dubbo.group.impl;



import com.dubbo.group.api.IShbyjlAccountWs;
import com.dubbo.group.api.ShbyjlAccountQueryReqDto;
import com.dubbo.group.api.ShbyjlAccountQueryResDto;
import com.dubbo.group.facade.FacadeFactory;
import com.dubbo.group.facade.Request;
import com.dubbo.group.facade.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户借口
 * Created by BF100252 on 2017/1/20.
 */
@Service
public class ShbyjlAccountWsImpl implements IShbyjlAccountWs {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * 服务分组
     */
    public Response<ShbyjlAccountQueryResDto> query(Request<ShbyjlAccountQueryReqDto> request){
        ShbyjlAccountQueryResDto resDto = new ShbyjlAccountQueryResDto();
        resDto.setData("分组一");
        return FacadeFactory.createOkResponse(resDto);
    }


    @Override
    public List<String> mergeResult() {
        List<String> menus = new ArrayList<String>();
        menus.add("group-1.1");
        menus.add("group-1.2");
        return menus;
    }

    /**
     * 服务分组+分组合并实例2
     */
    @Override
    public Response<List<ShbyjlAccountQueryResDto>> queryList(Request<ShbyjlAccountQueryReqDto> request){
        logger.info("11111111111"+Thread.currentThread().getId());
        List<ShbyjlAccountQueryResDto> list = new ArrayList<ShbyjlAccountQueryResDto>();
        ShbyjlAccountQueryResDto resDto = new ShbyjlAccountQueryResDto();
        resDto.setData("分组一");
        list.add(resDto);
        return FacadeFactory.createOkResponse(list);
    }

    @Override
    public Response<ShbyjlAccountQueryResDto> cache(Request<ShbyjlAccountQueryReqDto> request) {
        ShbyjlAccountQueryResDto resDto = new ShbyjlAccountQueryResDto();
        resDto.setData("分组一");

        return FacadeFactory.createOkResponse(resDto);
    }

}
