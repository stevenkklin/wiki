package com.linchao.backend.service.impl;

import com.linchao.backend.mapper.DemoMapper;
import com.linchao.backend.pojo.Demo;
import com.linchao.backend.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Steven
 * @create 2023-04-07-21:33
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public List<Demo> list() {
        return demoMapper.selectByExample(null);
    }
}
