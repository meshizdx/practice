package com.spring.boot.rabbitmq.controller;

import com.spring.boot.rabbitmq.mq.sender.RabbitMqSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by BF100177 on 2017/6/2.
 */
@RestController
public class MqController {

    @Autowired
    private RabbitMqSender sender;

    @RequestMapping("/send")
    public String send(@RequestParam("msg") String msg){
        sender.sendMsg(msg);
        return "OK!";
    }

}
