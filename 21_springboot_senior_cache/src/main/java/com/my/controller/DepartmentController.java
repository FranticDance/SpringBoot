package com.my.controller;

import com.my.bean.Department;
import com.my.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author admin
 * @create 2018-07-24 14:49
 */
@RestController
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;


    @GetMapping("/dept/{id}")
    public Department getDeptById(@PathVariable("id") Integer id){
        return departmentService.getDeptById(id);
    }
}
