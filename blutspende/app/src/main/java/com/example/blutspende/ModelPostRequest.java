package com.example.blutspende;

public class ModelPostRequest {
    private String userName,phoneNumber,bloodGroup,location,date;

    public ModelPostRequest() {
    }

    public ModelPostRequest(String userName, String phoneNumber, String bloodGroup, String location, String date) {
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.bloodGroup = bloodGroup;
        this.location = location;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }
}
