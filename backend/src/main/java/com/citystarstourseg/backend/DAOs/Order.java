package com.citystarstourseg.backend.DAOs;

import java.time.*;

public class Order {

    private String id, serialNumber, requesterID, requesterName, approverID, approverName;
    private LocalDate orderDate, creationDate;
    private boolean isOrderApproved;

    public Order(String serialNumber, String requesterID, LocalDate orderDate) {
        this.serialNumber = serialNumber;
        this.requesterID = requesterID;
        this.orderDate = orderDate;
    }

    public Order(String id, String serialNumber, String requesterID, String approverID, LocalDate orderDate, boolean isOrderApproved) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.requesterID = requesterID;
        this.approverID = approverID;
        this.orderDate = orderDate;
        this.isOrderApproved = isOrderApproved;
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

    public void setOrderApproved(boolean orderApproved) {
        isOrderApproved = orderApproved;
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

    public boolean isOrderApproved() {
        return isOrderApproved;
    }
}
