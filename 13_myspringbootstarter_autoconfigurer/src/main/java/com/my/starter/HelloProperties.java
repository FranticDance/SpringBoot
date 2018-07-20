package com.my.starter;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author admin
 * @create 2018-07-20 17:44
 */
@ConfigurationProperties(prefix = "my.hello")
public class HelloProperties {

    private String attributeA;
    private String attributeB;

    public String getAttributeA() {
        return attributeA;
    }

    public void setAttributeA(String attributeA) {
        this.attributeA = attributeA;
    }

    public String getAttributeB() {
        return attributeB;
    }

    public void setAttributeB(String attributeB) {
        this.attributeB = attributeB;
    }
}
