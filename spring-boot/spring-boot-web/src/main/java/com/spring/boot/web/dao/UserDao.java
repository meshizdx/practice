package com.spring.boot.web.dao;

import com.spring.boot.web.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by BF100177 on 2017/5/27.
 */
@Mapper
public interface UserDao {

    List<User> queryUsers();

    User findUserById(Integer id);

    int updateUser(User user);

    int addUser(User user);

    int delUser(User user);
}
