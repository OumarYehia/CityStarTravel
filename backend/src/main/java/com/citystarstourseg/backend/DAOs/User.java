package com.citystarstourseg.backend.DAOs;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {

    private String userName, fullName, emailAddress, passwordSalt, passwordHash, mobileNumber;
    private int roleID;
    private String isApproved, isBlocked;
    private LocalDateTime dateAccountCreated;

    private String roleName;

    public User(String userName, String fullName, String emailAddress, String passwordSalt, String passwordHash, String mobileNumber, int roleID, LocalDateTime dateAccountCreated) {
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(String isApproved) {
        this.isApproved = isApproved;
    }

    public String getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(String isBlocked) {
        this.isBlocked = isBlocked;
    }

    public LocalDateTime getDateAccountCreated() {
        return dateAccountCreated;
    }

    public void setDateAccountCreated(LocalDateTime dateAccountCreated) {
        this.dateAccountCreated = dateAccountCreated;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
