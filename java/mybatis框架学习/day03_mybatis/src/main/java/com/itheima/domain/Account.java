package com.itheima.domain;

public class Account {
    Integer id;
    private User user;
    Integer uid;
    Double money;
    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", user=" + user +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


}
