package com.example.springbootdemo;

import com.example.springbootdemo.mapper.UserMapper;
import com.example.springbootdemo.model.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

@SpringBootApplication   //开启了Spring的组件扫描和Spring Boot的自动配置功能
@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
@MapperScan("com.example.springbootdemo.mapper")
public class SpringbootdemoApplication implements CommandLineRunner{

	//@Autowired
	//private UserMapper userMapper;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);  //负责启动引导应用程序
	}

	@Override
	public void run(String... args) throws Exception {
      // User user = userMapper.findUserById(10);
      // System.out.println(user.getUsername()+' '+user.getSex());
	}
}
