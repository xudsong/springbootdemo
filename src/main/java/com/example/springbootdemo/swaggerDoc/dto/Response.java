package com.example.springbootdemo.swaggerDoc.dto;

import lombok.Data;

@Data
public class Response {
    /**
     * 返回参数
     */
    private String description;

    /**
     * 参数名
     */
    private String name;

    /**
     * 说明
     */
    private String remark;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public  Response(){

    }

    public Response(String description, String name, String remark) {
        this.description = description;
        this.name = name;
        this.remark = remark;
    }
}
