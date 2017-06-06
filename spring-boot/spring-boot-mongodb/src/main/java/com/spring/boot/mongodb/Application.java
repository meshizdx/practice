package com.spring.boot.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by BF100177 on 2017/5/25.
 */

// @SpringBootApplication 开启自动装配
@SpringBootApplication
@EnableMongoRepositories
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
