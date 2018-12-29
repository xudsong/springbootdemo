package com.example.springbootdemo.controller;

import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Hello控制器服务")
@RestController
public class HelloController {


   @Autowired
    private UserMapper userMapper;

   @ApiOperation(value = "hello方法", notes = "hello方法")
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    private String index(){
        return "Hello World!";
    }

    @ApiOperation(value = "登录", notes = "根据用户id查询用户信息")
    @ApiImplicitParam(name = "id",value = "用户id",required = true, dataType = "String",paramType = "path")
    @RequestMapping(value = "/login/{id}",method = RequestMethod.GET)
    private String login(@PathVariable(value = "id") String id){
        User user = userMapper.findUserById(id);
        return "userName: " + user.getUsername() + " userId: "+user.getId();
    }
}
