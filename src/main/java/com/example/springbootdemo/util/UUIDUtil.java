package com.example.springbootdemo.util;

import java.util.UUID;

public class UUIDUtil {

    /**
     * 生成UUID
     * @return
     */
    public static String createUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args) {
        String str = UUIDUtil.createUUID();
        System.out.printf(str);
    }

}
