package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Dept;
import com.example.springbootdemo.mapper.DeptMapper;
import com.example.springbootdemo.service.DeptService;
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
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
