package com.my.service;

import com.my.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @create 2018-07-27 16:15
 */
@Service
public class BookService {

    @RabbitListener(queues = {"atguigu.news"})
    public void receive (Book book){
        System.out.println("接收到消息：");
        System.out.println(book);
    }

    @RabbitListener(queues = "atguigu")
    public void receive2(Message message){ //如果还想要消息头这些信息，可以这样接收消息
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
