package com.spring.boot.rabbitmq.mq.listener;

import com.spring.boot.rabbitmq.config.AmqpConfig;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 消息监听
 * Created by BF100177 on 2017/6/2.
 */
@Configuration
@RabbitListener(queues = AmqpConfig.QUEUE)
public class RabbitMqListener {

    @RabbitHandler
    public void process(String message) {
        System.out.println("----------------------- Receiver : " + message);
    }

}
