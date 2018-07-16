package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author admin
 * @create 2018-07-16 17:02
 */
@Controller
public class HelloController {

    @GetMapping("/abc")
    public String hello(){
        return "success";
    }
}
