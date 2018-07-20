package com.my.starter;

/**
 * @author admin
 * @create 2018-07-20 17:40
 */

/**
 * 模拟一个组件，并且这个组件有一些配置属性
 */
public class HelloService {

    HelloProperties helloProperties;

    public HelloProperties getHelloProperties() {
        return helloProperties;
    }

    public void setHelloProperties(HelloProperties helloProperties) {
        this.helloProperties = helloProperties;
    }

    public String sayHello(String name){
        System.out.println("读取attributeA：" + helloProperties.getAttributeA());
        System.out.println("读取attributeB：" + helloProperties.getAttributeB());
        return ("hello,"+name);
    }
}
