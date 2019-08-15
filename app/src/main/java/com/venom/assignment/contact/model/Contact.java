package com.venom.assignment.contact.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable  {

    private String first_name;
    private String last_name;
    private String mobile;


    protected Contact(Parcel in) {
        first_name = in.readString();
        last_name = in.readString();
        mobile = in.readString();
    }

    public static final Creator<Contact> CREATOR = new Creator<Contact>() {
        @Override
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        @Override
        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(mobile);
    }
}
