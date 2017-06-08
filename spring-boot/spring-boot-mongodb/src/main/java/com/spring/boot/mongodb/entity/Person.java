package com.spring.boot.mongodb.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;
import java.util.LinkedHashSet;

/**
 * Created by BF100177 on 2017/5/31.
 */
// @Document 映射领域对象与 MongoDB 的一个文档
@Document
public class Person {

    // @Id 注明此属性为文档Id
    @Id
    private String id;
    private String name;
    private Integer age;

    //  @Field("locs") 注解此属性在文档中的名称为 locs locations 属性将以数组形式 存在当前数据记录中
    @Field("locs")
    private Collection<Location> locations = new LinkedHashSet<Location>();

    public Person(String name, Integer age) {
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

    public Collection<Location> getLocations() {
        return locations;
    }

    public void setLocations(Collection<Location> locations) {
        this.locations = locations;
    }
}
