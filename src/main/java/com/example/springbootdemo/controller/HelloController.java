package com.example.springbootdemo.controller;

import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiImplicitParam(name = "id",value = "用户id",required = true, dataType = "String",paramType = "path",defaultValue = "1")
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    private String login(@RequestParam(value = "id") String id){
        User user = userMapper.findUserById(id);
        return "userName: " + user.getUsername() + " userId: "+user.getId();
    }
}
