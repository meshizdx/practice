package com.spring.boot.mybatis;

import com.spring.boot.mybatis.dao.UserDaoByAnnotation;
import com.spring.boot.mybatis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 注解方式
 * Created by BF100177 on 2017/5/26.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MyBatisTestByAnnotation {

    @Autowired
    private UserDaoByAnnotation userDaoByAnnotation;

    @Test
    public void test1(){

        //通过属性 CRUD 操作
        userDaoByAnnotation.addUser("张三","男",26);

        User user = userDaoByAnnotation.findUserByName("张三");
        System.out.println("查询user信息为：" + user.toString());

        userDaoByAnnotation.updateByUserName("女",29,"张三");
        user = userDaoByAnnotation.findUserByName("张三");
        System.out.println("修改后user信息为：" + user.toString());

        userDaoByAnnotation.deleteByName("张三");
        user = userDaoByAnnotation.findUserByName("张三");
        System.out.println("删除user后" + user);
    }

    @Test
    public void test2(){

        //动态sql 通过实体类 CRUD 操作

        User user = new User();
        user.setName("李四");
        user.setAge(22);
        userDaoByAnnotation.addUserByUser(user);

        User user1 = new User();
        user1.setName("李四");
        user1 = userDaoByAnnotation.findUserByUser(user1);
        System.out.println("查询user信息为：" + user1);

        user1.setSex("男");
        userDaoByAnnotation.updateUserByUser(user1);
        user1 = userDaoByAnnotation.findUserByUser(user1);
        System.out.println("修改后user信息为：" + user1);

        userDaoByAnnotation.deleteUserByUser(user1);
        user1 = userDaoByAnnotation.findUserByUser(user1);
        System.out.println("删除后user信息为：" + user1);



    }

}
