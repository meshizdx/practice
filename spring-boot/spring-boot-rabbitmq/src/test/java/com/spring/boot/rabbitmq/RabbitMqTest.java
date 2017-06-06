package com.spring.boot.rabbitmq;

import com.spring.boot.rabbitmq.mq.sender.RabbitMqSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by BF100177 on 2017/6/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RabbitMqTest {

    @Autowired
    private RabbitMqSender sender;

    @Test
    public void testMq(){

        sender.sendMsg("只是一条信息");

    }
}
