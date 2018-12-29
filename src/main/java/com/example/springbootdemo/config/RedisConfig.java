package com.example.springbootdemo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

/**
 * Redis缓存配置类
 */
//@Configuration
//@EnableCaching
public class RedisConfig {

//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory factory){
//        RedisCacheManager cacheManager = RedisCacheManager.create(factory);
//        return cacheManager;
//    }
//
//    @Bean(name = "redisTemplate")
//    public RedisTemplate<String,Serializable> redisTemplate(RedisConnectionFactory factory){
//        RedisTemplate<String,Serializable> template = new RedisTemplate<>();
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new StringRedisSerializer());
//        template.setConnectionFactory(factory);
//        return template;
//    }

}
