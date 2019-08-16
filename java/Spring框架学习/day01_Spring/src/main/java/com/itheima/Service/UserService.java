package com.itheima.Service;


import com.itheima.dao.UserDao;

public class UserService {
    private UserDao userdao;

    public UserService(){
        System.out.println("UserService被创建了");
    }

    public UserDao getUserdao() {
        return userdao;
    }

    public void setUserdao(UserDao userdao) {
        this.userdao = userdao;
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
    /**
     * 耦合性高，当需要修改时，需要修改源代码进行操作
     * 这时我们来通过Spring的IOC控制反转来创建对象
     */





}
