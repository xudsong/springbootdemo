package com.example.springbootdemo;

import com.xiaoleilu.hutool.util.IdcardUtil;

public class MainTest {

    public static void main(String[] args){
        String idCard = "362321199011015934";

        //身份证验证
        System.out.println(IdcardUtil.isValidCard(idCard));
    }
}
