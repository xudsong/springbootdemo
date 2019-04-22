package com.example.springbootdemo.config;

import com.example.springbootdemo.config.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 自定义过滤器注册
 */
@Configuration
public class CustomFilterRegConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        //注入自定义过滤器
        registrationBean.setFilter(new CustomFilter());
        //设置过滤器名称
        registrationBean.setName("customFilter");
        //拦截路径
        registrationBean.addUrlPatterns("/*");
        //设置顺序
        registrationBean.setOrder(1);

        return registrationBean;
    }

}
