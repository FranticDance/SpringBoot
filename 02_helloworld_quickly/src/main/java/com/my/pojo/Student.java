package com.my.pojo;

import java.util.Date;

/**
 * @author admin
 * @create 2018-06-26 17:46
 */
public class Student {
    private long id;
    private String name;
    private Date birthday;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
