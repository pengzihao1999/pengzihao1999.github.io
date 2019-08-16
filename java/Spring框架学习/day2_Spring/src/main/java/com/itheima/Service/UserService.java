package com.itheima.Service;


import com.itheima.dao.UserDao;

public class UserService {
    private UserDao userdao;

    public UserService(){
        System.out.println("UserService被创建了");
    }
    public void saveAccount(){
        userdao.saveUser();
    }
    @Override
    public String toString() {
        return "UserService{" +
                "userdao=" + userdao +
                '}';
    }
}
