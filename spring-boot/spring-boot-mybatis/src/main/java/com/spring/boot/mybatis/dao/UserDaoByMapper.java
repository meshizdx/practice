package com.spring.boot.mybatis.dao;


import com.spring.boot.mybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by BF100177 on 2017/5/27.
 */
@Mapper
public interface UserDaoByMapper {
    //查询
    User findUserByName(@Param("name") String name);

    //新增
    int addUser(User user);

    //修改
    int updateUser(User user);

    //删除
    int delUser(User user);


}
