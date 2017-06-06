package com.spring.boot.mybatis;

import com.spring.boot.mybatis.dao.UserDaoByMapper;
import com.spring.boot.mybatis.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 通过Mapper文件
 * Created by BF100177 on 2017/5/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MybatisTestByMapper {

    @Autowired
    private UserDaoByMapper userDaoByMapper;
    
    @Test
    public void test(){

        //新增
        User user = new User();
        user.setName("王五");
        user.setSex("男");
        user.setAge(22);
        userDaoByMapper.addUser(user);

        //查询
        user = userDaoByMapper.findUserByName("王五");
        System.out.println("查询user信息：" + user.toString());

        //修改
        user.setSex("女");
        userDaoByMapper.updateUser(user);
        user = userDaoByMapper.findUserByName("王五");
        System.out.println("修改user信息：" + user.toString());

        //删除
        userDaoByMapper.delUser(user);
        user = userDaoByMapper.findUserByName("王五");
        System.out.println("删除user：" + user);
    }

}
