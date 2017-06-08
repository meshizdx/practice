package com.spring.boot.base.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by BF100177 on 2017/5/25.
 */

@Configuration
// @ConfigurationProperties 将配置文件属性 与Bean中属性关联
@ConfigurationProperties(locations = {"classpath:properties.properties"},prefix = "base.user")
public class BasePropertiesByBean {

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
