package com.my.mapper;

import com.my.bean.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface EmployeeMapper {

    @Select("SELECT * FROM employee WHERE id=#{id}")
    public Employee getEmpById(Integer id);

    @Update("UPDATE employee set lastName=#{lastName},email=#{email},gender=#{gender},d_id=#{dId} WHERE id=#{id}")
    public void updateEmp(Employee employee);

    @Delete("DELETE FROM employee where id=#{id}")
    public void deleteEmp(Integer id);

    @Insert("INSERT INTO employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    public void insertEmp(Employee employee);

    @Select("SELECT * FROM employee WHERE lastName=#{lastName}")
    public Employee getEmpByLastName(String lastName);
}
