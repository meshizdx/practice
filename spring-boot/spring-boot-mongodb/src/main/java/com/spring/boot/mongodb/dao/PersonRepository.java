package com.spring.boot.mongodb.dao;

import com.spring.boot.mongodb.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by BF100177 on 2017/5/31.
 */
public interface PersonRepository extends MongoRepository<Person,String> {

    // 支持方法名查询
    Person findByName(String name);

    // @Query 参数通过 json 构造
    @Query("{'age':?0}")
    List<Person> whithQueryFindByAge(Integer age);

}
