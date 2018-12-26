package com.example.springbootdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springbootdemo.entity.UserDb;
import com.example.springbootdemo.mapper.UserDbMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserDbMapper userDbMapper;

    @Test
    public void testSelect(){
        System.out.println("test start");
//        List<UserDb> userDbList = userDbMapper.selectList(null);
        QueryWrapper<UserDb> wrapper = new QueryWrapper<>();
        wrapper.eq("username","null");
        List<UserDb> userDbList = userDbMapper.selectList(wrapper);
        //Assert.assertEquals(5,userDbList.size());
        userDbList.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        UserDb userDb = new UserDb();
        userDb.setUsername("xss");
        userDbMapper.insert(userDb);
    }
}
