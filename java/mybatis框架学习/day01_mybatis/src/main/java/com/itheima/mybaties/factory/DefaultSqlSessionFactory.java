package com.itheima.mybaties.factory;

import com.itheima.conf.Configuration;
import com.itheima.mybaties.session.DefaultSqlSession;
import com.itheima.mybaties.session.SqlSession;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;
    //得到配置信息
    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }
    //返回sqlSession实例对象
    public SqlSession openSession() {
        System.out.println("Facoryconfiguration = " + configuration);
        return new DefaultSqlSession(configuration);
    }
}
