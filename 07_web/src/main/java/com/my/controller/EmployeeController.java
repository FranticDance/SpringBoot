package com.my.controller;

import com.my.dao.DepartmentDao;
import com.my.dao.EmployeeDao;
import com.my.entities.Department;
import com.my.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author admin
 * @create 2018-07-02 10:44
 */

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //员工列表
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        //返回的结果将会由thymeleaf模板引擎进行解析拼串
        //classpath:/templates/xxxx.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddEmpPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //员工添加操作
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        //添加成功返回列表页面
        return "redirect:/emps";
    }

    //来到员工修改页面,根据点击的员工id进行数据回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        //修改成功返回列表页面
        return "redirect:/emps";
    }


    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
