package com.venom.assignment.contact.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ContactList {
    @SerializedName("contacts")
    public List<Contact> contact;

    public List<Contact> getContact() {
        return contact;
    }
}