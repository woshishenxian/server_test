package com.vince.demo.user.entity;

public class User {
    String username;
    int password;
    String phone;

    public User() {
    }

    public User(String username, int password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "user{name='" + username + "'," + "password=" + password + "," + "phone=" + phone + "}";
    }
}
