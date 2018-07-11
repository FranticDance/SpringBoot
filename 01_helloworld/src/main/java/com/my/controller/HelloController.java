package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author admin
 * @create 2018-06-26 16:39
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String HelloWorld(){
        return "hello world";
    }
}
