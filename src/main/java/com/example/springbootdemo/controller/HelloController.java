package com.example.springbootdemo.controller;

import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

   @Autowired
    private UserMapper userMapper;

    @RequestMapping("/hello")
    private String index(){
        return "Hello World!";
    }

    @RequestMapping("/login")
    private String login(Integer id){
        User user = userMapper.findUserById(id);
        return "userName: " + user.getUsername() + " userId: "+user.getId();
    }
}
