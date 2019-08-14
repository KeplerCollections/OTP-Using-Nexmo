package com.venom.assignment.contact.support;


public interface OnItemClickListener<T extends Object> {
    void onClick(T contact);
}