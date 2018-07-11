package com.my.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @create 2018-06-26 18:18
 */
/**
 * 将配置文件中配置的每一个属性的值，映射到这个组件中
 * @ConfigurationProperties：告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 *      prefix = "person"：配置文件中哪个下面的所有属性进行一一映射
 *
 * 只有这个组件是容器中的组件，才能容器提供的@ConfigurationProperties功能；
 *
 */
@Component  //标记着是一个组件，相当于在配置文件中的bean配置
@ConfigurationProperties(prefix = "person") //进行值注入，默认是从全局配置文件中获取值
//@Validated //进行数据校验
//@PropertySource(value = {"classpath:person.properties"}) //加载指定路径下的配置文件
public class Person {
    //@Value("${person.last-name}") //这个注解可以为单个值注入值，如果是一个bean批量注入，则使用上面的@ConfigurationProperties注解
    //另外，@ConfigurationProperties支持JSR303数据校验和松散语法，复杂类型包装（比如map），@value注解不支持，但是@Value注解支持SPEL表达式
    //所以要根据实际情况来选用，比如想在Controller中获取一个配置文件的值，就可以用@Value,如果是一个bean获取值，就用@ConfigurationProperties
    //@Email //进行邮箱格式校验，但是注意使用@Value方式注入不会生效
    private String lastName;
    //@Value("#{11*2}")
    private Integer age;
    private Boolean boss;
    private Date birth;

    private Map<String,Object> maps;
    private List<Object> lists;

    private Dog dog;

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
