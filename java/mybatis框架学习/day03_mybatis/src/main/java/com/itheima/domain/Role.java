package com.itheima.domain;

import java.util.List;

public class Role {
    private Integer ID;
    private String roleName;
    private List<User> userList;

    private String roleDesc;

    @Override
    public String toString() {
        return "Role{" +
                "ID=" + ID +
                ", roleName='" + roleName + '\'' +
                ", userList=" + userList +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }



    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}