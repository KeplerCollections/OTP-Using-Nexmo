package com.venom.assignment.contact.presenter;


import com.venom.assignment.contact.support.AppLogic;
import com.venom.assignment.contact.model.Contact;
import com.venom.assignment.contact.model.DatabaseHelper;
import com.venom.assignment.contact.support.MVPImpl;
import com.venom.assignment.contact.model.Message;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static com.venom.assignment.contact.model.Constants.first_name;
import static com.venom.assignment.contact.model.Constants.last_name;
import static com.venom.assignment.contact.model.Constants.mobile;

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
        JSONArray jsonArray;
        JSONObject jsonObject;
        List<Contact> mList=new ArrayList<>();
        try {
            InputStream is = view.getAppContext().getAssets().open("generated.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            jsonArray=new JSONArray(new String(buffer, "UTF-8"));
            for(int i=0;i<jsonArray.length();i++){
                jsonObject=jsonArray.getJSONObject(i);
                mList.add(new Contact(jsonObject.getString(first_name),
                        jsonObject.getString(last_name),
                        jsonObject.getString(mobile)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return mList;
    }
}
