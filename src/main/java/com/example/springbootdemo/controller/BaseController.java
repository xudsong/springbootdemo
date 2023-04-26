package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @PostMapping("/ping")
    public String ping(){
        return "ping";
    }

}
