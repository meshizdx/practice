package com.spring.boot.web.controller;

import com.spring.boot.web.entity.User;
import com.spring.boot.web.enums.ResultCode;
import com.spring.boot.web.service.UserService;
import com.spring.boot.web.web.JsonResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * RESTful
 * Created by BF100177 on 2017/5/27.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value="获取所有用户列表", notes="")
    @RequestMapping(value={""}, method= RequestMethod.GET)
    public JsonResult getUserList() {
        List<User> users = userService.queryUsers();
        return new JsonResult(ResultCode.SUCCESS,users);

    }

    @ApiOperation(value="创建用户", notes="根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value="", method=RequestMethod.POST)
    public JsonResult postUser(@RequestBody User user) {
        try {
            userService.addUser(user);
            return new JsonResult();
        }catch (Exception e){
            return new JsonResult(ResultCode.SYS_ERROR);
        }
    }

    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取用户详细信息")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long")
    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    public JsonResult getUser(@PathVariable Integer id) {
        try {
            User user = userService.findUserById(id);
            if(user == null){
                return new JsonResult(ResultCode.EXCEPTION,"未查询到用户信息");
            }
            return new JsonResult(ResultCode.SUCCESS,user);
        }catch (Exception e){
            return new JsonResult(ResultCode.SYS_ERROR);
        }
    }

    @ApiOperation(value="更新用户详细信息", notes="根据url的id来指定更新对象，并根据传过来的user信息来更新用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "更新内容实体类", required = true, dataType = "User")
    })
    @RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
    public JsonResult putUser(@PathVariable Integer id, @RequestBody User user) {
        try {
            User u = userService.findUserById(id);
            if(u == null){
                return new JsonResult(ResultCode.EXCEPTION,"未查询到用户信息");
            }
            user.setId(id);
            userService.updateUser(user);
            return new JsonResult(ResultCode.SUCCESS);
        }catch (Exception e){
            return new JsonResult(ResultCode.SYS_ERROR);
        }

    }

    @ApiOperation(value="删除用户", notes="根据url的id来指定删除对象")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
    public JsonResult deleteUser(@PathVariable Integer id) {
        try {
            User user = new User();
            user.setId(id);
            userService.delUser(user);
            return new JsonResult();
        }catch (Exception e){

            return new JsonResult(ResultCode.SYS_ERROR,e.getMessage());
        }
    }

}
