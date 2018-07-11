package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author admin
 * @create 2018-06-26 16:36
 */
//使用本注解标注主程序。这个注解有很多作用
// 1.其中一个是自动扫描包，扫描范围是被这个注解标注的程序所在的包及其子包。
//也就是说，这里扫描的包就是com.my，如果controller在这个包外面，那就扫描不到了，请求就会404
    //2.被本注解标注的类，本身也是一个组件，即是一个@Component
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args){

        //启动spring应用
        SpringApplication.run(HelloWorldMainApplication.class,args);
    }
}
