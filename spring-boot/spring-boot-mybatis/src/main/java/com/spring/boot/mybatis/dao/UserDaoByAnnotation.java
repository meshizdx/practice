package com.spring.boot.mybatis.dao;

import com.spring.boot.mybatis.dao.SqlProvider.UserProvider;
import com.spring.boot.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * 通过注解的方式操作 Dao层
 * Created by BF100177 on 2017/5/26.
 */
@Mapper
public interface UserDaoByAnnotation {

    /**
     * 通过属性操作
     * */

    //查询
    @Select("SELECT * FROM YLF.USER WHERE NAME = #{name}")
    User findUserByName(@Param("name") String name);

    //新增
    @Insert("INSERT INTO YLF.USER(NAME,SEX,AGE) VALUES(#{name},#{sex},#{age})")
    int addUser(@Param("name") String name, @Param("sex") String sex, @Param("age") Integer age);

    //修改
    @Update("UPDATE YLF.USER SET SEX = #{sex}, AGE = #{age} WHERE NAME = #{name}")
    int updateByUserName(@Param("sex") String sex, @Param("age") Integer age, @Param("name") String name);

    //删除
    @Delete("DELETE FROM YLF.USER WHERE NAME = #{name}")
    int deleteByName(@Param("name") String name);

    /**
     * 通过实体类操作,动态组织sql语句
     * */

    //查询
    @SelectProvider(type = UserProvider.class, method = "findUser")
    User findUserByUser(User user);

    //新增
    @InsertProvider(type = UserProvider.class, method = "addUser")
    @Options(useGeneratedKeys=true, keyProperty="ID")
    int addUserByUser(User user);

    //修改
    @DeleteProvider(type = UserProvider.class, method = "updateUser")
    int updateUserByUser(User user);

    //删除
    @DeleteProvider(type = UserProvider.class, method = "deleteUser")
    int deleteUserByUser(User user);



}
