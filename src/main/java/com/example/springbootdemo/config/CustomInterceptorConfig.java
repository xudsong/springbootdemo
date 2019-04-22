package com.example.springbootdemo.config;

import com.example.springbootdemo.config.interceptor.CustomInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 注入自定义拦截器
 */
@Configuration
public class CustomInterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //配置拦截器
        registry.addInterceptor(new CustomInterceptor())
                //配置拦截路径
        .addPathPatterns("/**")
                //配置不拦截的路径
        .excludePathPatterns("/api/release/**");
    }

}
