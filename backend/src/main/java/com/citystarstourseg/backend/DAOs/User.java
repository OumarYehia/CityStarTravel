package com.citystarstourseg.backend.DAOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

    private String userName, fullName, emailAddress, passwordHash, mobileNumber;
    private byte[] passwordSalt;
    private int roleID;
    private String isApproved, isBlocked;
    private LocalDateTime dateAccountCreated;

    private String roleName;

    public User(String userName, String fullName, String emailAddress, byte[] passwordSalt, String passwordHash, String mobileNumber, int roleID, LocalDateTime dateAccountCreated) {
        this.userName = userName;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.passwordSalt = passwordSalt;
        this.passwordHash = passwordHash;
        this.mobileNumber = mobileNumber;
        this.roleID = roleID;
        this.dateAccountCreated = dateAccountCreated;
    }

    public String getUserName() {
        return userName;
    }


    public String getFullName() {
        return fullName;
    }


    public String getEmailAddress() {
        return emailAddress;
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
}
