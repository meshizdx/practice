package com.dubbo.stub;

import com.alibaba.fastjson.JSON;
import com.dubbo.callback.CallBackConsumer;
import com.dubbo.callback.api.CallBackListener;
import com.dubbo.common.IShbyjlAccountWs;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryReqDto;
import com.dubbo.common.dto.accountQuery.ShbyjlAccountQueryResDto;
import com.dubbo.common.facade.FacadeFactory;
import com.dubbo.common.facade.Response;
import com.dubbo.stub.api.BarService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 博学之，审问之，慎思之，明辨之，笃行之。
 * 人一能之，己百之；人十能之，己千之。
 * 果能此道矣，虽愚必明，虽柔必强。
 *
 * @Description:
 * @create by shaott at 2017-06-09 15:03
 **/
public class StubConsumer {

    public static void main(String[] args) throws Exception {
        String config = StubConsumer.class.getPackage().getName().replace('.', '/') + "/stub-consumer.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(config);
        context.start();
        BarService barService = (BarService)context.getBean("barService");
        ShbyjlAccountQueryReqDto reqDto = new ShbyjlAccountQueryReqDto();
        reqDto.setUserId("110511124");
        Response<ShbyjlAccountQueryResDto> resDtoResponse =  barService.query(FacadeFactory.createRequest("","",reqDto));
        System.out.println(JSON.toJSONString(resDtoResponse));
    }
}
