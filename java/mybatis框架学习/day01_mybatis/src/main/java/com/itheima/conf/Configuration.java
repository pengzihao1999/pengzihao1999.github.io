package com.itheima.conf;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private Map<String, Mapper> mappers = new HashMap<String, Mapper>();
    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    private String Driver;

    @Override
    public String toString() {
        return "Configuration{" +
                "Driver='" + Driver + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", mappers=" + mappers +
                '}';
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Map<String, Mapper> getMappers() {
        return mappers;
    }

    public void setMappers(Map<String, Mapper> mappers) {
        //
        this.mappers.putAll(mappers);
    }

    private String password;
    private String url;


}
