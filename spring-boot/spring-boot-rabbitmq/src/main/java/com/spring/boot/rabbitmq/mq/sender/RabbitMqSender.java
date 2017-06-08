package com.spring.boot.rabbitmq.mq.sender;

import com.spring.boot.rabbitmq.config.AmqpConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by BF100177 on 2017/6/2.
 */
@Component
public class RabbitMqSender implements RabbitTemplate.ConfirmCallback{

    private RabbitTemplate rabbitTemplate;
    /**
     * 构造方法注入
     */
    @Autowired
    public RabbitMqSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }

    public void sendMsg(String content){

        rabbitTemplate.convertAndSend(content);
    }

    @Override
    public void confirm(CorrelationData correlationId, boolean isSuccess, String message) {

        System.out.println(" 回调id:" + correlationId);
        if (isSuccess) {
            System.out.println("消息成功消费");
        } else {
            System.out.println("消息消费失败:" + message);
        }
    }
}
