package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author admin
 * @create 2018-06-28 11:16
 */
@Controller
public class HelloController {

    //映射首页，可以被thymeleaf解析，除了这种方法，也可以采用WebMvcConfigurer来配置自己的请求映射
   /* @RequestMapping({"/","/login"})
    public String login(){
        return "login";
    }*/

    @RequestMapping("/success")
    public String success(Map<String,String> map){
        map.put("k1","hello");


        return "success";
    }
}
