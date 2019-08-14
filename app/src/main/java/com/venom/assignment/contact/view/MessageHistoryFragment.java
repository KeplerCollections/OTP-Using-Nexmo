package com.venom.assignment.contact.view;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.venom.assignment.contact.view.adapters.MessageHistoryAdapter;
import com.venom.assignment.contact.support.BaseFragment;
import com.venom.assignment.contact.model.Message;
import com.venom.assignment.contact.support.OnItemClickListener;

public class MessageHistoryFragment extends BaseFragment implements OnItemClickListener<Message> {


    private MessageHistoryAdapter mAdapter;
    private Bundle bundle;


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        if (communicator.getMessageHistory() == null || communicator.getMessageHistory().isEmpty()) {
            dna.setVisibility(View.VISIBLE);
        } else {
            dna.setVisibility(View.GONE);
            mAdapter = new MessageHistoryAdapter(communicator.getMessageHistory(), this);
            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);
        }
    }

    @Override
    public void onClick(Message message) {
        bundle = new Bundle();
//        bundle.putParcelable(Constants.CONTACTS, contact);
//        communicator.fragStartActivity(VideoInfoActivity.class, bundle);

    }
}
