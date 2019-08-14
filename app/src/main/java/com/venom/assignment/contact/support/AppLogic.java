package com.venom.assignment.contact.support;

import android.content.Context;

import com.venom.assignment.contact.model.Contact;
import com.venom.assignment.contact.model.Message;

import java.util.List;

public class AppLogic {

    /********* Logic for home************/
    public interface MainView extends MVP.BaseView {
        Context getAppContext();
    }

    public interface MainLogic extends MVP.BasePresenter<MainView> {
        List<Contact> getContacts();

        List<Message> getMessageHistory();
    }

    /********* Logic for nEW MESSAGE************/
    public interface NewMessageView extends MainView {
      void onResponse(String response);
    }

    public interface NewMessageLogic extends MVP.BasePresenter<NewMessageView> {
        void sendMessage(Message message);
    }
}
