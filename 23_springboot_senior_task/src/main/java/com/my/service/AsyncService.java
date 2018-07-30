package com.my.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @create 2018-07-30 9:58
 */
@Service
public class AsyncService {

    @Async
    public void sayHello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello....");
    }

}
