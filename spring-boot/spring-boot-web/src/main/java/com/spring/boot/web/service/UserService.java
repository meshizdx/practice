package com.spring.boot.web.service;

import com.spring.boot.web.entity.User;

import java.util.List;

/**
 * Created by BF100177 on 2017/5/27.
 */
public interface UserService {


    /**
     * 查询所有用户信息
     * */
    List<User> queryUsers();

    /**
     * 根据id查询
     * */
    User findUserById(Integer id);

    /**
     * 更新用户信息
     * */
    int updateUser(User user);

    /**
     * 新增用户
     * */
    int addUser(User user);

    /**
     * 删除用户
     * */
    int delUser(User user);

}
