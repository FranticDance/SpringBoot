package com.my.controller;

import com.my.bean.Employee;
import com.my.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee queryEmpById(@PathVariable("id") Integer id){
        Employee empById = employeeService.getEmpById(id);
        return empById;
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        return employeeService.updateEmp(employee);
    }

    @GetMapping("/delemp")
    public String deleteEmp(Integer id){
        employeeService.deleteEmp(id);
        return "success";
    }

    @GetMapping("/emp/lastName/{lastName}")
    public Employee getEmpByLastName(@PathVariable("lastName") String lastName){
        return employeeService.getEmpByLastName(lastName);
    }

}
