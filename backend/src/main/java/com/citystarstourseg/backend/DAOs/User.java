package com.citystarstourseg.backend.DAOs;

import java.time.LocalDateTime;

public class User {

    private String userName, fullName, email, password, mobileNumber, passwordHash, confirmPassword;
    private byte[] passwordSalt;
    private int roleID;
    private String isApproved, isBlocked;
    private LocalDateTime dateAccountCreated;

    private String roleName;

    public User(String userName, String fullName, String email, byte[] passwordSalt, String passwordHash, String mobileNumber, int roleID, LocalDateTime dateAccountCreated) {
        this.userName = userName;
        this.fullName = fullName;
        this.email = email;
        this.passwordSalt = passwordSalt;
        this.passwordHash = passwordHash;
        this.mobileNumber = mobileNumber;
        this.roleID = roleID;
        this.dateAccountCreated = dateAccountCreated;
    }

    public User() {}

    public String getUserName() {
        return userName;
    }


    public String getFullName() {
        return fullName;
    }


    public String getEmail() {
        return email;
    }


    public byte[] getPasswordSalt() {
        return passwordSalt;
    }


    public String getPasswordHash() {
        return passwordHash;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }


    public int getRoleID() {
        return roleID;
    }

    public LocalDateTime getDateAccountCreated() {
        return dateAccountCreated;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return userName +" - "+ fullName +" - "+ email +" - "+ password +" - "+ mobileNumber +" - "+ passwordHash;
    }
}
