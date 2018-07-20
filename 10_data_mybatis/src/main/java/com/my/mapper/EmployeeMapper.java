package com.my.mapper;

import com.my.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by admin on 2018/7/20.
 */
@Mapper
public interface EmployeeMapper {

    public void insertEmp(Employee employee);

    public Employee getEmpById(Integer id);
}
