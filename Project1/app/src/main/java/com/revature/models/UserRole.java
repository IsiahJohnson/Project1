package com.revature.models;

public class UserRole{
    private String role;
    private int roleId;

    public UserRole(String role, int roleId) {
        this.role = role;
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "UserRole{" +
                "role='" + role + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}



