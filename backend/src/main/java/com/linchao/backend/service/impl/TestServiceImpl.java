package com.linchao.backend.service.impl;

import com.linchao.backend.mapper.TestMapper;
import com.linchao.backend.pojo.Test;
import com.linchao.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Steven
 * @create 2023-04-07-21:33
 */
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> list() {
        return testMapper.list();
    }
}
