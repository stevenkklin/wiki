package com.linchao.backend.controller;

import com.linchao.backend.pojo.Demo;
import com.linchao.backend.pojo.Test;
import com.linchao.backend.service.DemoService;
import com.linchao.backend.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Steven
 * @create 2023-04-07-16:57
 */
@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @Value("${test.hello:TEST}")
    private String testHello;

    @Autowired
    private TestService testService;

    @Autowired
    private DemoService demoService;

    @GetMapping("/hello")
    public String hello() {
        return "Hello " + testHello;
    }

    @GetMapping("/test/list")
    public List<Test> list() {
        return testService.list();
    }

    @GetMapping("/demo/list")
    public List<Demo> demoList() {
        return demoService.list();
    }
}
