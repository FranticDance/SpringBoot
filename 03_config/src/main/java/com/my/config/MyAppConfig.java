package com.my.config;

import com.my.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @create 2018-06-27 14:17
 */
@Configuration
public class MyAppConfig {
    @Bean //使用这个注解向容器添加组件，组件id默认为方法名
    public HelloService helloService(){
        System.out.println("向容器添加helloService组件...");
        return new HelloService();
    }
}
