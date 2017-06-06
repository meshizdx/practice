package com.spring.boot.redis;


import com.spring.boot.redis.pojo.Person;
import com.spring.boot.redis.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by BF100177 on 2017/5/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class RedisTest {

    @Autowired
    private CacheService cacheService;


    @Test
    public void redisTest(){

        Person person = new Person();
        person.setName("ylf");
        person.setAge(25);

        cacheService.set("person",person);
        Person p2 = (Person) cacheService.get("person");
        System.out.println(p2.toString());

    }

}
