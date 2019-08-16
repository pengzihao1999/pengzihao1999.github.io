package com.itheima.mybaties.session;


import java.sql.Connection;

public interface SqlSession {
    public <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
    public Connection getConnection();
}
