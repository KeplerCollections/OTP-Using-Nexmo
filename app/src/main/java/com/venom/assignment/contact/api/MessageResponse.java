package com.venom.assignment.contact.api;

import com.google.gson.annotations.SerializedName;

public class MessageResponse {

    @SerializedName("message-count")
    private String messageCount;

    @SerializedName("messages")
    private ServerMessage[] messages;

    public String getMessageCount ()
    {
        return messageCount;
    }

    public void setMessageCount (String messageCount)
    {
        this.messageCount = messageCount;
    }

    public ServerMessage[] getMessages ()
    {
        return messages;
    }

    public void setMessages (ServerMessage[] messages)
    {
        this.messages = messages;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message-count = "+messageCount+", messages = "+messages+"]";
    }
}