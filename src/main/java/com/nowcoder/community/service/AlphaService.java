package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//容器中可以创建多个实例
//@Scope("prototype")
public class AlphaService {

    //依赖AlphaDao
    @Autowired
    private AlphaDao alphaDao;

    public  AlphaService() {
        System.out.println("构造");
    }
    //初始化方法在构造器之后调用
    @PostConstruct
    public void init() {
        System.out.println("初始化");
    }
    //在销毁对象前调用
    @PreDestroy
    public  void destroy() {
        System.out.println("销毁");
    }

    public String find() {
        return alphaDao.select();
    }
}
