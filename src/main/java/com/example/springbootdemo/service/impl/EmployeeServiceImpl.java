package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.entity.Employee;
import com.example.springbootdemo.mapper.EmployeeMapper;
import com.example.springbootdemo.service.EmployeeService;
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
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
