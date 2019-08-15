package com.venom.assignment.contact.presenter;


import com.google.gson.Gson;
import com.venom.assignment.contact.model.ContactList;
import com.venom.assignment.contact.support.AppLogic;
import com.venom.assignment.contact.model.Contact;
import com.venom.assignment.contact.model.DatabaseHelper;
import com.venom.assignment.contact.support.MVPImpl;
import com.venom.assignment.contact.model.Message;


import java.io.InputStream;
import java.util.List;


public class MainPresenter extends MVPImpl<AppLogic.MainView> implements AppLogic.MainLogic {


    private DatabaseHelper db;

    @Override
    public List<Contact> getContacts() {
        return getJSONFromAsset();
    }

    @Override
    public List<Message> getMessageHistory() {
        if(view==null)
            return null;
        if (db == null)
            db = new DatabaseHelper(view.getAppContext());
        return db.getAll();
    }

    public List<Contact> getJSONFromAsset() {
        if(view==null)
            return null;
        try {

            InputStream is = view.getAppContext().getAssets().open("generated.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            return (new Gson().fromJson(new String(buffer, "UTF-8"), ContactList.class)).getContact();

        } catch (Exception ex) {
            return null;
        }
    }
}
