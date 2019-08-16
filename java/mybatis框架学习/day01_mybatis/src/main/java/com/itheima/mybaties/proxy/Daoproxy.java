package com.itheima.mybaties.proxy;

import com.itheima.conf.Mapper;
import com.itheima.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class Daoproxy implements InvocationHandler {
    private Map<String,Mapper> mappers;
    private Connection connection;
    public Daoproxy(Map<String, Mapper> mappers, Connection connection) {
        this.mappers = mappers;
        this.connection = connection;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //因为mybatis规定配置的id必须和方法名称一致
        String methodname = method.getName();
        //mappers的key是全域class+method
        String classname = method.getDeclaringClass().getName();
        System.out.println("classname = " + classname);
        System.out.println("methodname = " + methodname);
        System.out.println("connection = " + connection);
        //拼接key
        String key = classname + "." + methodname;
        Mapper mapper = mappers.get(key);
        //得到返回类型
        if (method.getReturnType() == List.class) {
            return new Executor().selectList(mapper, connection);
        }
        else{
            return null;
        }
    }
}
