package com.spring.boot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BF100177 on 2017/5/25.
 */

// @RestController= @Controller + @ResponseBody
@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    String helloWorld() {
        return "Hello World !";
    }

}
