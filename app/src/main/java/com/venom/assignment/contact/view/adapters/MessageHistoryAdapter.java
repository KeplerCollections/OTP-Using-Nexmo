package com.venom.assignment.contact.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.venom.assignment.contact.R;
import com.venom.assignment.contact.model.Message;
import com.venom.assignment.contact.support.OnItemClickListener;

import java.util.List;

public class MessageHistoryAdapter extends RecyclerView.Adapter<MessageHistoryAdapter.MyViewHolder> {

    private final OnItemClickListener onItemClickListener;
    private List<Message> mList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTitle, mDes,mTime;
        public ImageView mImageView;

        public MyViewHolder(View view) {
            super(view);
            mImageView = view.findViewById(R.id.imageView);
            mTitle = view.findViewById(R.id.title);
            mDes = view.findViewById(R.id.des);
            mTime = view.findViewById(R.id.time);
        }
    }


    public MessageHistoryAdapter(List<Message> mList, OnItemClickListener onItemClickListener) {
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
        final Message message= mList.get(position);
        holder.mImageView.setVisibility(View.GONE);
        holder.mTitle.setText(message.getName());
        holder.mDes.setText("OTP : "+message.getOtp());
        holder.mTime.setText(message.getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(message);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}