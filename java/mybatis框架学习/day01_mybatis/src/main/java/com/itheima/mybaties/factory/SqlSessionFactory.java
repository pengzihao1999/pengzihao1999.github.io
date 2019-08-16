package com.itheima.mybaties.factory;

import com.itheima.mybaties.session.SqlSession;

public interface SqlSessionFactory {
    SqlSession openSession();
}
