package com.itheima.dao;

public class UserDao {
    public void saveUser(){
        System.out.println("用户被保存了...");
    }
    public UserDao(){
        System.out.println(" UserDao被创建了 " );
    }
    public void init(){
        System.out.println("我被初始化了");
    }
    public void destory(){
        System.out.println("我被销毁了");
    }
}
