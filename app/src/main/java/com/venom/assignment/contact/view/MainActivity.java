package com.venom.assignment.contact.view;

import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.venom.assignment.contact.R;
import com.venom.assignment.contact.view.adapters.TabAdapter;
import com.venom.assignment.contact.support.AppLogic;
import com.venom.assignment.contact.support.BaseActivity;
import com.venom.assignment.contact.support.Communicator;
import com.venom.assignment.contact.model.Contact;
import com.venom.assignment.contact.support.MVPActivity;
import com.venom.assignment.contact.model.Message;
import com.venom.assignment.contact.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends MVPActivity<AppLogic.MainLogic> implements AppLogic.MainView, Communicator {

    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected AppLogic.MainLogic createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewPager = findViewById(R.id.pager);
        tabLayout = findViewById(R.id.tab_layout);
        setAdapter();
    }

    private void setAdapter() {
        adapter = new TabAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }


    // start communicator implementation
    @Override
    public List<Contact> getContacts() {
        return presenter.getContacts();
    }

    @Override
    public List<Message> getMessageHistory() {
        return presenter.getMessageHistory();
    }

    @Override
    public void fragStartActivity(Class<? extends BaseActivity> aClass, Bundle bundle) {
            startActivity(aClass,bundle);
    }
    // end communicator implementation


    // start applogic  implementation

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }
    // end applogic implementation

}
