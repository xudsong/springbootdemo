package com.example.springbootdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * 用于内网访问外网的REST请求配置
 */
@Configuration
public class RestTemplateConfig {

    //基于jdk的Spring的RestTemplate
    @Bean
    @Primary
    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
        return new RestTemplate(factory);
    }

    @Bean
    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setReadTimeout(5000); //ms
        factory.setConnectTimeout(5000); //ms
        return factory;
    }

    //基于springcloud的RestTemplate
//    @LoadBalanced
//    @Bean
//    RestTemplate loadBalanced(){
//        return new RestTemplate();
//    }

}
