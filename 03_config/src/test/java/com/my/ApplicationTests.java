package com.my;

import com.my.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBoot单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext context;


	@Test
	public void contextLoads() {
		System.out.println(person);
	}

	@Test
	public void testHelloService(){
		boolean b = context.containsBean("helloService");
		System.out.println(b);
	}

}
