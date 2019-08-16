package com.itheima.Factory;

import com.itheima.dao.UserDao;

public class StaticBeanFactory {
    public static UserDao getUserDao(){
        return new UserDao();
    }
}
