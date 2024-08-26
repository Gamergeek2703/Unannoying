package com.unannoying.app;

/**
 * Created by amutha_c on 31,July,2023
 */
public class Contacts {
    private String contactNo;
    private String time;

    public Contacts(String contactNo, String time) {
        this.contactNo = contactNo;
        this.time = time;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }




}
