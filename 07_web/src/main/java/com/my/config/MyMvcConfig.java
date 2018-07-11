package com.my.config;

import com.my.component.LoginHandlerInterceptor;
import com.my.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author admin
 * @create 2018-06-29 9:33
 */
//使用WebMvcConfigurer可以扩展SpringMVC的功能。（JAVA1.7是用WebMvcConfigurerAdapter，因为1.8接口中可以有方法实现，所以这个类过时了）
@Configuration
//@EnableWebMvc//Springboot为我们自动配置了很多组件，是属于扩展SpringMVC，但是如果用了@EnableWebMvc这个注解
//代表你想全面接管SpringMVC，那么SpringBoot的自动配置就会失效（比如访问静态页面就不行了）。所以，如果既想用SpringBoot的配置，同时也想用
//我们自己的扩展配置，就别加@EnableWebMvc注解，反之则加上注解
public class MyMvcConfig implements WebMvcConfigurer{

    //自定义一个请求映射，浏览器发送/my请求来到success对应的视图页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/my").setViewName("success");
    }

    //所有的webMvcConfigurer组件都会一起起作用，注意一定要加上@Bean注解将之加入容器中才能生效
    //添加自定义请求映射webMvcConfigurer器
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {


            //添加自己的请求映射
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //添加自己的拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //拦截除了登录请求，登录页面的请求之外的所有请求，静态资源SpringBoot已经做好了映射，不用配置
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/index.html","/","/user/login","/webjars/**","/asserts/**","**/favicon.ico");//
            }
        };
        return webMvcConfigurer;
    }

    //添加自定义localeResolver国际化器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
