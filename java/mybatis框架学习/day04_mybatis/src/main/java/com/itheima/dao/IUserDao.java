package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAllByStep();

    User findUserByID(int i);

    void updateByID(Integer i);
}
