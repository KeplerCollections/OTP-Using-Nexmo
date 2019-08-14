package com.venom.assignment.contact.support;


import android.os.Bundle;

import com.venom.assignment.contact.model.Contact;
import com.venom.assignment.contact.model.Message;

import java.util.List;

public interface Communicator {
    List<Contact> getContacts();

    List<Message> getMessageHistory();

    void fragStartActivity(Class<? extends BaseActivity> aClass, Bundle bundle);
}