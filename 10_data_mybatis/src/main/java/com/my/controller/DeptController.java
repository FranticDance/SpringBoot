package com.my.controller;

import com.my.bean.Department;
import com.my.bean.Employee;
import com.my.mapper.DepartmentMapper;
import com.my.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }


    @GetMapping("/dept/{id}")
    public Department selectDept(@PathVariable("id") Integer id){
        return departmentMapper.selectDept(id);
    }

    @GetMapping("/emp/{id}")
    public Employee selectEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }



}
