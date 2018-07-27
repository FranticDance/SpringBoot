package com.my;

import com.my.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void createExchange(){
	/*	Exchange exchange = new DirectExchange("amqpadmin");
		amqpAdmin.declareExchange(exchange);*/

	/*	Queue queue = new Queue("amqpadmin.queque", true);
		amqpAdmin.declareQueue(queue);*/

		Binding amqpadmin = new Binding("amqpadmin.queque", Binding.DestinationType.QUEUE, "amqpadmin", "amqpadmin.test", null);
		amqpAdmin.declareBinding(amqpadmin);
	}

	/**
	 * 测试direct点对点的方式发送数据
	 */
	@Test
	public void contextLoads() {
		String exchange = "exchange.direct";
		String routeKey = "atguigu.news";
		HashMap<String, Object> message = new HashMap<>();
		message.put("msg","这是第一个消息");
		message.put("data", Arrays.asList("aaa","bbb"));
		//默认使用Java序列化来发送数据
		Book book = new Book("丫丫", "校长");
		rabbitTemplate.convertAndSend(exchange, routeKey, book);
	}

	/**
	 * 接收数据
	 */
	@Test
	public void receive(){
		String queueName = "atguigu.news";
		Object o = rabbitTemplate.receiveAndConvert(queueName);//注意，如果是自定义的bean，必须保留无参构造器，不然无法反序列化
		System.out.println(o.getClass());
		System.out.println(o);
	}



}
