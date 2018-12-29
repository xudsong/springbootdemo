package com.example.springbootdemo.mapper;

import org.apache.ibatis.annotations.Mapper ;
import com.example.springbootdemo.model.User;
import org.springframework.stereotype.Repository;

@Repository  //避免使用@Autowired注解时找不到UserMapper，所以加上了这个注解
@Mapper  //用了＠Mapper注解,Spring启动时会自动扫描该接口，这样就可以在需要使用时直接注入 Mapper 了
public interface UserMapper {

    User findUserById(String id);

}
