package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.UserDb;
import com.example.springbootdemo.mapper.UserDbMapper;
import com.example.springbootdemo.service.UserDbService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xudasong
 * @since 2018-12-12
 */
@Service
public class UserDbServiceImpl extends ServiceImpl<UserDbMapper, UserDb> implements UserDbService {

}
