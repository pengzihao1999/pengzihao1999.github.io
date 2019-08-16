package com.itheima.mybaties.buider;

import com.itheima.conf.Configuration;
import com.itheima.mybaties.factory.DefaultSqlSessionFactory;
import com.itheima.mybaties.factory.SqlSessionFactory;
import com.itheima.utils.XMLConfigBuilder;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {
    public static SqlSessionFactory build(InputStream config){
        //加载配置信息
        Configuration configuration = XMLConfigBuilder.loadConfiguration(config);
        //
        System.out.println("configuration = " + configuration);
        return new DefaultSqlSessionFactory(configuration);
    }
}
