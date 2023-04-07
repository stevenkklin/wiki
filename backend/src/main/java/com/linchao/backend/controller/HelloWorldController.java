package com.linchao.backend.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Steven
 * @create 2023-04-07-16:57
 */
@RestController
public class HelloWorldController {

    @Value("${test.hello:TEST}")
    private String testHello;

    @GetMapping("/hello")
    public String hello() {
        return "Hello " + testHello;
    }
}
