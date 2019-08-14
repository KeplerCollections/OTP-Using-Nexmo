package com.venom.assignment.contact.model;

public class Constants {
    public static final String CONTACTS = "Contacts";
    public static final String MESSAGES = "Messages";
    public static final String HI = " Hi, Your OTP is:";

    //params
    public static final String first_name = "first_name";
    public static final String last_name = "last_name";
    public static final String mobile = "mobile";
    public static final String name = "name";
    public static final String otp = "otp";
    public static final String id= "id";
    public static final String contact = "Contact";


    //tables
    public static final String TABLE_NAME = "table_messages";
    public static final String COLUMN_TIMESTAMP = "time_stamp";
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + id + " INTEGER PRIMARY KEY,"
                    + name + " TEXT,"
                    + otp + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";


}
