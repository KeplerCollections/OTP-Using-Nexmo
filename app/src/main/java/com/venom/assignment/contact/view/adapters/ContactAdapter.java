package com.venom.assignment.contact.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.venom.assignment.contact.R;
import com.venom.assignment.contact.model.Contact;
import com.venom.assignment.contact.support.OnItemClickListener;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {

    private final OnItemClickListener onItemClickListener;
    private List<Contact> mList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle, mDes,mTime;

        public MyViewHolder(View view) {
            super(view);
            mTitle = view.findViewById(R.id.title);
            mDes = view.findViewById(R.id.des);
            mTime = view.findViewById(R.id.time);
        }
    }


    public ContactAdapter(List<Contact> mList, OnItemClickListener onItemClickListener) {
        this.mList = mList;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Contact contact= mList.get(position);
        holder.mTitle.setText(contact.getFirst_name()+" "+contact.getLast_name());
        holder.mDes.setText(contact.getMobile());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(contact);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}