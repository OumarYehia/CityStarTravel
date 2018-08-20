package com.citystarstourseg.backend.DAOs;

public class UserRequest {
    private String userName;
    private String fullName;
    private String email;
    private String password;
    private String mobileNumber;
    private String roleID;


    public String getUserName() {
        return userName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getRoleID() {
        return roleID;
    }
}
