package com.my.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author admin
 * @create 2018-06-29 14:02
 */
@Controller
public class LoginController {

//    @GetMapping
//    @PutMapping
//    @DeleteMapping
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username, @RequestParam ("password")String password,
                        Map<String,Object> map, HttpSession httpSession){
        if(!StringUtils.isEmpty(username) && "123".equals(password)){
            httpSession.setAttribute("loginUser",username);

            //登录成功
            //return "dashboard";//由于是通过post到后台主页面，所以存在表单重复提交的问题（主页面刷新，提交的还是登录请求）
            return "redirect:/main.html";//解决表单重复提交，自定义一个请求映射，然后通过重定向的方式到主页面
                            //但是我们知道，如果这样重定向的话，登录功能相当于没有了，只要写对后台主页面地址，就可以绕过登录
                            //如何解决呢？使用拦截器
        }else {
            //登录失败
            map.put("msg","用户名密码错误");
            return "login";
        }
    }
}
