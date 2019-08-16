package com.itheima.conf;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
@PropertySource("classpath:jdbconfig.properties")
@Configuration
public class sqlConfig {
    /*
       配置类要做的事情，消除xml配置
       xml配置做了三件事
       1.在dao层通过set方式注入了queryRunner
       2.queryRunner通过构造器注入了DateSource
       3.DateSource通过set方法注入了连接数据库的四大要素
       所以，我们现在只需要把这些对象生成并放到Spring容器中就可以进行自动注入了
    */
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Bean("queryRunner")
    @Scope("prototype")
    public QueryRunner getQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }
    @Bean
    public DataSource getDataSource(){
        try {
            System.out.println("driver = " + driver);
            System.out.println("url = " + url);
            System.out.println("username = " + username);
            System.out.println("password = " + password);
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setDriverClass(driver);
            return dataSource;
        } catch (PropertyVetoException e) {
            throw  new RuntimeException(e);
        }
    }
}
