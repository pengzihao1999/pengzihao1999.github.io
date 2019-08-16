package com.itheima.Factory;

import com.itheima.dao.UserDao;

public class BeanFactory {
    public UserDao getUserDao(){
        return new UserDao();
    }
    BeanFactory(){
        System.out.println("工厂被创建了");
    }
}
