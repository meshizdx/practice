package com.spring.boot.web.service.impl;

import com.spring.boot.web.dao.UserDao;
import com.spring.boot.web.entity.User;
import com.spring.boot.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BF100177 on 2017/5/27.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUsers() {
        return userDao.queryUsers();
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int delUser(User user) {
        return userDao.delUser(user);
    }
}
