package com.spring.boot.base.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by BF100177 on 2017/5/25.
 */
@Configuration
public class BaseProperties {

    //通过 @Value 注解 注入 application.properties 中定义的属性值

    @Value("${base.user.name}")
    private String userName;

    @Value("${base.user.password}")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
