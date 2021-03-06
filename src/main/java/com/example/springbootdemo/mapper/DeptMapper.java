package com.example.springbootdemo.mapper;

import com.example.springbootdemo.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xudasong
 * @since 2018-12-12
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {

}
