package com.venom.assignment.contact.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.venom.assignment.contact.view.adapters.ContactAdapter;
import com.venom.assignment.contact.support.BaseFragment;
import com.venom.assignment.contact.model.Constants;
import com.venom.assignment.contact.model.Contact;
import com.venom.assignment.contact.support.OnItemClickListener;


public class ContactFragment extends BaseFragment implements OnItemClickListener<Contact> {


    private ContactAdapter mAdapter;
    private Bundle bundle;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dna.setVisibility(View.GONE);
        mAdapter = new ContactAdapter(communicator.getContacts(), this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(Contact contact) {
        bundle = new Bundle();
        bundle.putParcelable(Constants.contact, contact);
        communicator.fragStartActivity(ContactInfoActivity.class, bundle);

    }
}
