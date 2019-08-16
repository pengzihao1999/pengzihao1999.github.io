package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    /*
        查询所有返回List集合
     */
    List<User> findAll();
    /*
       插入元素
     */
    void insert(User user);

    void update(User user);

    void deleteUser(int i);

    User QueryById(int i);

    List<User> QueryByName(String s);

    int QueryTotal();
}
