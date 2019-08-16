package com.itheima.utils;

import com.itheima.conf.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataSourceutils {
    public static Connection getConnection(Configuration cfg){
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(), cfg.getUsername(), cfg.getPassword());
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
