package com.citystartravel.backend.entity.user.response;

public class UserIdentityAvailabilityResponse {

    private boolean available;

    public UserIdentityAvailabilityResponse(boolean available) {
        this.available = available;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
