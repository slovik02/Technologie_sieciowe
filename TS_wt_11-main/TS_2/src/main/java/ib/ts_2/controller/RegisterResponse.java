package ib.ts_2.controller;

import ib.ts_2.CommonTypes.UserRole;

public class RegisterResponse {

    private long userID;
    private String username;

    private UserRole role;

    public RegisterResponse(long userID, String username, UserRole role) {
        this.userID = userID;
        this.username = username;
        this.role = role;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
