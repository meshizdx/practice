package com.spring.boot.dubbo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


/**
 * 核心启动类
 * Created by BF100177 on 2017/5/25.
 */
// @ImportResource 导入资源配置文件
@ImportResource("classpath:dubbo/dubbo.xml")
// @SpringBootApplication 开启自动装配
@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
