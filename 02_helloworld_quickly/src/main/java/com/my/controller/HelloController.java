package com.my.controller;

import com.my.pojo.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @create 2018-06-26 17:40
 */
/*@Controller
@ResponseBody//这个注解如果不写在方法上写在类上，那么这个类所有方法返回的数据直接写给浏览器，如果是对象转为json数据*/
@RestController//如果使用了这个注解，就不用写上面两种注解了
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world quickly";
    }

    @RequestMapping("/student")
    public Student queryStudent(){
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setBirthday(new Date());
        return student;
    }

    @RequestMapping("/studentlist")
    public List<Student> queryStudentList(){
        // 使用静态数据
        List<Student> list = new ArrayList<Student>();
        Student student1 = new Student();
        student1.setId(1000l);
        student1.setName("张三");
        student1.setBirthday(new Date());

        Student student2 = new Student();
        student2.setId(1000l);
        student2.setName("张三");
        student2.setBirthday(new Date());

        list.add(student1);
        list.add(student2);
        return list;
    }


}
