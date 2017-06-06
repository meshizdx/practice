package com.spring.boot.redis.pojo;

import java.io.Serializable;

/**
 * Created by BF100177 on 2017/5/31.
 */
//redis 存储通过 spring 提供的 Serializer 序列化到数据库 需实现 Serializable 接口
public class Person implements Serializable {

    private String id;
    private String name;
    private Integer age;

    public Person(){

    }

    public Person(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
