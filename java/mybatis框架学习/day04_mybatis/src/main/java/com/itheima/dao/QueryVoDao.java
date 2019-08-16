package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;

public interface QueryVoDao {
    List<User> QueryUserByVo(QueryVo q);

    List<User> QueryUserByList(QueryVo queryVo);
}
