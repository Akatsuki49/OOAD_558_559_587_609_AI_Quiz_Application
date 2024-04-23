package com.example.demo.utils;

public class RequestObject {
    private String sendSowmeshDetails;

    // Default constructor
    public RequestObject() {
    }

    // Getter
    public String getSendSowmeshDetails() {
        return sendSowmeshDetails;
    }

    // Setter
    public void setSendSowmeshDetails(String sendSowmeshDetails) {
        this.sendSowmeshDetails = sendSowmeshDetails;
    }

    // Override toString() method if needed
    @Override
    public String toString() {
        return "RequestObject{" +
                "sendSowmeshDetails='" + sendSowmeshDetails + '\'' +
                '}';
    }
}