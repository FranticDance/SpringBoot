package com.my;

import com.my.bean.Employee;
import com.my.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate; //专门操作字符串的k-v

	@Autowired
	RedisTemplate redisTemplate; //k-v都是对象

	@Autowired
	RedisTemplate empRedisTemplate; //k-v都是对象



	/*
	* redis常见的五大数据类型：String（字符串），List（列表），Set（集合），Hash（散列），ZSet（有序集合）
	*
	* */
	@Test
	public void test01(){
		stringRedisTemplate.opsForValue().append("msg","hello");
		stringRedisTemplate.opsForList().leftPush("mylist2","ttt");

		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);
	}

	//测试报错对象
	@Test
	public void test02(){
		//将employee对象保存到redis中，要求Employee类必须可序列化
		//redisTemplate.opsForValue().set("emp01",employeeMapper.getEmpById(1));
		redisTemplate.opsForValue().set("emp01",employeeMapper.getEmpById(1));
		//如果不想将序列化后的对象保存到redis中，而是只想将数据以json的方式保存
		//1.可以将对象先转为json
		//2.redis默认使用jdk序列化器，可以切换redis的序列化器。
		empRedisTemplate.opsForValue().set("emp02",employeeMapper.getEmpById(1));

	}


	@Test
	public void contextLoads() {

		Employee empById = employeeMapper.getEmpById(1);
		System.out.println(empById);
	}

}
