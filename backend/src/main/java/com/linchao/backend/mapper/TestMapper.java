package com.linchao.backend.mapper;

import com.linchao.backend.pojo.Test;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Steven
 * @create 2023-04-07-21:22
 */

@Mapper
public interface TestMapper {

    public List<Test> list();
}
