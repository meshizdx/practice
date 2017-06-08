package com.spring.boot.mybatis.dao.SqlProvider;

import com.spring.boot.mybatis.entity.User;
import org.apache.ibatis.jdbc.SQL;

/**
 * 动态sql组成
 * Created by BF100177 on 2017/5/26.
 */
public class UserProvider {

    public String addUser(final User user){
        return new SQL(){{
            INSERT_INTO("YLF.USER");
            if(user.getName() != null){
                VALUES("NAME","#{name}");
            }
            if(user.getSex() != null){
                VALUES("SEX","#{sex}");
            }
            if(user.getAge() != null){
                VALUES("AGE","#{age}");
            }
        }}.toString();
    }

    public String findUser(final User user){
        return new SQL(){{
            SELECT("ID as id, NAME as name, SEX as sex, AGE as age");
            FROM("YLF.USER");
            if(user.getId() != null){
                WHERE("ID = #{id}");
            }
            if(user.getName() != null){
                WHERE("NAME = #{name}");
            }
            if(user.getSex() != null){
                WHERE("SEX = #{sex}");
            }
            if(user.getAge() != null){
                WHERE("AGE = #{age}");
            }
        }}.toString();
    }

    public String updateUser(final User user){
        return new SQL(){{
            UPDATE("YLF.USER");
            if(user.getName() != null){
                SET("NAME = #{name}");
            }
            if(user.getSex() != null){
                SET("SEX = #{sex}");
            }
            if(user.getAge() != null){
                SET("AGE = #{age}");
            }
            WHERE("ID = #{id}");
        }}.toString();
    }

    public String deleteUser(final User user){
        return new SQL(){{
            DELETE_FROM("YLF.USER");
            if(user.getId() != null){
                WHERE("ID = #{id}");
            }
            if(user.getName() != null){
                WHERE("NAME = #{name}");
            }
            if(user.getSex() != null){
                WHERE("SEX = #{sex}");
            }
            if(user.getAge() != null){
                WHERE("AGE = #{age}");
            }
        }}.toString();
    }

}
