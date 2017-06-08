package com.spring.boot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Created by BF100177 on 2017/5/25.
 */

// @SpringBootApplication 开启自动装配
@SpringBootApplication
//@EnableConfigurationProperties自动映射一个POJO到Spring Boot配置文件（默认是application.properties文件）的属性集。
@EnableAutoConfiguration
// @MapperScan 可代替 @Mapper
@MapperScan("com.spring.boot.mybatis.dao")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
