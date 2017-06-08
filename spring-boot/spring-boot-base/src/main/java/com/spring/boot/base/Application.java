package com.spring.boot.base;


import com.zdx.spring.boot.zdx.ZdxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义 starter 使用
 * Created by BF100177 on 2017/5/25.
 */

// @SpringBootApplication 开启自动装配
@RestController
@SpringBootApplication
public class Application {

    //配置动作已在 自定义starter中完成，直接注入使用
    @Autowired
    private ZdxService zdxService;

    @RequestMapping("/")
    public String index() {
        return zdxService.say();
    }

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
