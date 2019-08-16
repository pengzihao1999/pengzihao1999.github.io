package com.itheima.domain;

public class AccountWithUser extends Account {
    private String username;
    private String address;
    @Override
    public String toString() {
        return "AccountWithUser{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                ", id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



}
