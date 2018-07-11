package com.my;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ImportResource(value = {"classpath:beans.xml"})// 可以使用这种方式给springboot添加配置文件，但是springboot推荐使用配置类的方式
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
