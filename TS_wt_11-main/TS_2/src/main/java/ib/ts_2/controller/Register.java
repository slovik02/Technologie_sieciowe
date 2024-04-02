package ib.ts_2.controller;

import ib.ts_2.CommonTypes.UserRole;

public class Register {
    private String password;

    private String username;

    private String email;

    private UserRole role;

    public Register(String password, String username, String email, UserRole role) {
        this.password = password;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
