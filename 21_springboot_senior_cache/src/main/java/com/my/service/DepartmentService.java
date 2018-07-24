package com.my.service;

import com.my.bean.Department;
import com.my.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @create 2018-07-24 14:44
 */
@Service
@CacheConfig(cacheNames = {"dept"})
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;


    //通过注解的方式来使用缓存

    @Cacheable(key = "#id",cacheManager = "deptCacheManager")
    public Department getDeptById(Integer id){
        System.out.println("查询" + id + "号部门");
        Department department = departmentMapper.getDeptById(id);
        return department;
    }


    /*
    //通过编程的方式使用缓存
    //首先注入这个service使用的缓存组件deptCacheManager
    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    //然后通过编程的方式放入缓存,注意虽然可以放入缓存，但是第二次查询相同部门时，还是会查数据库
    //应该要在代码中编写判断已存在数据就不查询数据的逻辑
    public Department getDeptById(Integer id){
        System.out.println("查询" + id + "号部门");
        Department department = departmentMapper.getDeptById(id);
        //获取缓存
        Cache dept = deptCacheManager.getCache("dept");
        //操作缓存
        dept.put("dept:" + id, department);
        return department;
    }*/



}
