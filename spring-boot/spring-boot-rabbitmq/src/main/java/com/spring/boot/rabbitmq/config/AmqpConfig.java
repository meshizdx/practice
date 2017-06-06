package com.spring.boot.rabbitmq.config;

import com.rabbitmq.client.AMQP;
import com.spring.boot.rabbitmq.properties.RabbitMq;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by BF100177 on 2017/6/2.
 */
// @Configuration 定义配置类
@Configuration
public class AmqpConfig {

    //队列
    public static final String QUEUE = "spring-boot-queue";
    //交换机
    public static final String DIRECTEX_CHANGE = "spring-boot-directex";
    //匹配键
    public static final String ROUTINGKEY = "boot";

    @Autowired
    private RabbitMq rabbitMq;

    //队列持久化
    @Bean
    public Queue springBootQueue(){
        return new Queue(QUEUE,true);
    }

    //连接mq
    @Bean
    public CachingConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setAddresses(rabbitMq.getHost());
        connectionFactory.setUsername(rabbitMq.getUsername());
        connectionFactory.setPassword(rabbitMq.getPassword());
        connectionFactory.setVirtualHost(rabbitMq.getVirtualHost());
        connectionFactory.setRequestedHeartBeat(rabbitMq.getRequestedHeartbeat());
        //显示调用（设置后才能进行消息回调）
        connectionFactory.setPublisherConfirms(rabbitMq.isPublisherConfirms());
        return connectionFactory;
    }

    //交换机
    @Bean
    public DirectExchange defaultExchange() {
        return new DirectExchange(DIRECTEX_CHANGE);
    }



    @Bean
    public Binding binding() {
        return BindingBuilder.bind(springBootQueue()).to(defaultExchange()).with(ROUTINGKEY);
    }

    @Bean
    //因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RabbitTemplate rabbitTemplate(){
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange(DIRECTEX_CHANGE);
        template.setRoutingKey(ROUTINGKEY);
        return template;
    }



}
