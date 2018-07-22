package com.my.service;

import com.my.bean.Employee;
import com.my.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "emp")//CacheConfig注解就是抽取公共配置，免得每个方法上面都写重复的配置
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    //放入缓存
    @Cacheable(/*cacheNames = {"emp"},*/condition = "#id>0",unless = "#id>1",key = "#id",sync = false )
    public Employee getEmpById(Integer id){
        System.out.println("查询" + id +"号员工");
        return employeeMapper.getEmpById(id);
    }


    //修改数据库中的数据，同时更新缓存。
    //但是要注意，如果这里更新的缓存，想覆盖掉其他方法的缓存。比如
    //上面getEmpById方法中放入了id为1的员工，这里更新了1号员工，想让
    //上面的缓存也被覆盖掉，要让这两个缓存的key相同。
    @CachePut(/*cacheNames = {"emp"},*/key = "#result.id")//#result就代表方法的返回值
    public Employee updateEmp(Employee employee){
        System.out.println("update " + employee);
        employeeMapper.updateEmp(employee);
        return employee;
    }


    //缓存清除
    //allEntries = true删除所有该缓存组件（这里就是emp）的缓存数据
    //beforeInvocation = true清除缓存的操作是否在方法执行之前执行。默认是在方法执行之后清除缓存。
    //在方法执行之前清除和方法执行之后清除缓存的区别主要在于如果方法内部出了异常，那么如果这
    // 里配置的是在方法执行之后清除缓存的话，就不会清除缓存了。反之，在方法运行之前清除缓存，那么
    //不管方法是否出现异常，缓存都会清除
    @CacheEvict(/*value = "emp",*/key = "#id",allEntries = true,beforeInvocation = true)
    public void deleteEmp(Integer id){
        System.out.println("删除员工" + id);
        //employeeMapper.deleteEmp(id);
    }



    //@Caching相当于一个组合注解，可以组合配置复杂的规则，但是要注意各个注解之间的影响。
    //比如下面的情况就会导致@Cacheable相当于失效。因为@CachePut会导致方法必须执行。所以
    //即使标注了@Cacheable，也会每次都查询数据库
    @Caching(
            cacheable = {
                @Cacheable(/*value = "emp",*/key = "#lastName")
    },
            put = {
                @CachePut(/*value = "emp",*/key = "#result.id"),
                @CachePut(/*value = "emp",*/key = "#result.email")
    })
    public Employee getEmpByLastName(String lastName){
        return employeeMapper.getEmpByLastName(lastName);
    }

}
