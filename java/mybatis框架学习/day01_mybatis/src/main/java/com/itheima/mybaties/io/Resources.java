package com.itheima.mybaties.io;

import java.io.InputStream;

public class Resources {
    /**
     *  获取配置信息资源
     */
    public static InputStream getResourceAsStream(String filepath){
        return Resources.class.getClassLoader().getResourceAsStream(filepath);
    }
}
