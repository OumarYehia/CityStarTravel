package com.citystarstourseg.backend.DAOs;

import org.apache.tomcat.jni.Local;

import java.time.*;

public class Order {

    private String id, serialNumber, requesterID, requesterName, approverID, approverName;
    private LocalDate orderDate, creationDate;
    private boolean isApproved;

    public Order(String serialNumber, String requesterID, LocalDate orderDate) {
        this.serialNumber = serialNumber;
        this.requesterID = requesterID;
        this.orderDate = orderDate;
    }

    public Order(String id, String serialNumber, String requesterID, String requesterName, String approverID, String approverName, LocalDate orderDate, boolean isApproved) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.requesterID = requesterID;
        this.requesterName = requesterName;
        this.approverID = approverID;
        this.approverName = approverName;
        this.orderDate = orderDate;
        this.isApproved = isApproved;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public String getApproverID() {
        return approverID;
    }

    public String getApproverName() {
        return approverName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public boolean isApproved() {
        return isApproved;
    }
}
