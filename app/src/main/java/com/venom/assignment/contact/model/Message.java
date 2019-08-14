package com.venom.assignment.contact.model;

public class Message {

    private int id;
    private String name;
    private String time;
    private String mobile;
    private String otp;
    private String message;

    public Message(String name, String time, String otp) {
        this.name = name;
        this.time = time;
        this.otp = otp;
    }

    public String getMessage() {
        return message;
    }

    public Message(String name, String mobile, String otp, String message) {
        this.name = name;
        this.mobile = mobile;
        this.otp = otp;
        this.message = message;
    }

    public String getMobile() {
        return mobile;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getOtp() {
        return otp;
    }
}
