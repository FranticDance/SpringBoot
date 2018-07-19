package com.my.mapper;

import com.my.bean.Department;
import org.apache.ibatis.annotations.*;
//必须使用Mapper注解来标注接口。但是如果太多mapper，可以使用MapperScan来
//指定扫描包的方式，就可以不用每个接口都标注了。MapperScan可以在主程序上标注
//也可以在配置类上面标注
//@Mapper
public interface DepartmentMapper {

    @Options(useGeneratedKeys = true,keyProperty = "id")//插入成功后，映射返回的主键
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Delete("delete from department where id=#{id}")
    public int deleteDept(Integer id);

    @Update("update department set department_name=#{departmentName} where id=#{id}")
    public int updateDept(Department department);

    //如果Javabean中的属性名和数据库名不一致并且是符合驼峰命名法的，那么数据绑定会失败，需要使用
    // ConfigurationCustomizer来定制属性，开启驼峰命名法，和其他的属性
    @Select("select * from department where id=#{id}")
    public Department selectDept(Integer id);

}
