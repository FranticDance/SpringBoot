package com.my.controller;

import com.my.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @create 2018-07-20 18:25
 */
@RestController

public class HelloController {

    @Autowired
    HelloService helloService;


    @GetMapping("/hello")
    public String hello(){
        String bob = helloService.sayHello("bob");
        return bob;
    }
}
