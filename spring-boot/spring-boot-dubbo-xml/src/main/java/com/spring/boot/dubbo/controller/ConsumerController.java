package com.spring.boot.dubbo.controller;

import com.alibaba.fastjson.JSON;
import com.hsq.component.busi.facade.FacadeFactory;
import com.hsq.component.busi.facade.Request;
import com.hsq.component.busi.facade.Response;
import com.mandao.prod.passage.dto.account.QueryAccInDto;
import com.mandao.prod.passage.dto.account.QueryAccOutDto;
import com.mandao.prod.passage.facade.account.IAccountFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by BF100177 on 2017/6/1.
 */
@RestController
public class ConsumerController {

    @Autowired
    private IAccountFacade accountFacade;

    @RequestMapping("/queryAccount")
    public String queryAccount(){
        QueryAccInDto inDto = new QueryAccInDto();
        inDto.setUserId("932500034");
        inDto.setBizType("SHBYJL");
        Request<QueryAccInDto> request = FacadeFactory.createRequest("springBoot", UUID.randomUUID().toString(),inDto);
        Response<QueryAccOutDto> response = accountFacade.queryAccount(request);
        if (response.isSuccess()){
            return JSON.toJSONString(response.getResult());
        }else {
            return JSON.toJSONString(response.getErrorMsg());
        }
    }

}
