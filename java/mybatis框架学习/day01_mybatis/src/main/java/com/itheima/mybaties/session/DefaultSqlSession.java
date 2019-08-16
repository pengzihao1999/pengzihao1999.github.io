package com.itheima.mybaties.session;

import com.itheima.conf.Configuration;
import com.itheima.mybaties.proxy.Daoproxy;
import com.itheima.utils.DataSourceutils;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Connection connection;
    public Connection getConnection(){
        Connection connection = DataSourceutils.getConnection(configuration);
        this.connection = connection;
        return connection;
    }
    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T getMapper(Class<T> daoInterfaceClass) {
        //进行代理 代理类Daoproxy
        //怎么进行代理？
        //在mappers中找到对应要执行的方法
        //怎么找？
        //当前类的名称，调用的方法名称
        //调用返回的T的对象的方法，实际上是在调用DaoProxy的invoke方法
        return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},new Daoproxy(configuration.getMappers(),this.getConnection()));
    }

    public void close()  {
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {

            }
        }
    }
}
