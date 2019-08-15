package com.venom.assignment.contact.presenter;


import android.util.Log;

import com.venom.assignment.contact.api.ApiClient;
import com.venom.assignment.contact.api.ApiInterface;
import com.venom.assignment.contact.model.DatabaseHelper;
import com.venom.assignment.contact.model.Message;
import com.venom.assignment.contact.support.AppLogic;
import com.venom.assignment.contact.support.MVPImpl;
import com.venom.assignment.contact.api.MessageResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NewMessagePresenter extends MVPImpl<AppLogic.NewMessageView> implements AppLogic.NewMessageLogic {
    private static final String NEXMO_API_KEY = "0e692c89";
    private static final String NEXMO_API_SECRET = "R3UPLgr4F3xGITOL";
    private static final String NEXMO_BRAND_NAME = "Kisan Network";
    private static final String TAG = "NewMessagePresenter";


    @Override
    public void sendMessage(final Message message) {
        final DatabaseHelper db=new DatabaseHelper(view.getAppContext());

        ApiInterface sendSMSapiInterface =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MessageResponse> call = sendSMSapiInterface.getMessageResponse(NEXMO_API_KEY, NEXMO_API_SECRET,
                NEXMO_BRAND_NAME, message.getMobile(), message.getMessage());
        call.enqueue(new Callback<MessageResponse>() {
            @Override
            public void onResponse(Call<MessageResponse> call, Response<MessageResponse> response) {
                try {
//                    Log.d(TAG, String.valueOf(response.code()));

                    if (response.code() == 200 && Integer.parseInt(response.body().getMessages()[0].getStatus()) == 0) {
//                    if (response.code() == 200) {
//                        Log.d(TAG, response.body().toString());
//                        Log.d(TAG, response.body().getMessages().toString());
//                        Log.d(TAG, response.body().getMessageCount());
//                        for (int i = 0; i < response.body().getMessageCount().length(); i++) {
//                            Log.d(TAG, response.body().getMessages()[0].getTo());
//                            Log.d(TAG, response.body().getMessages()[0].getMessageId());
//                            Log.d(TAG, response.body().getMessages()[0].getStatus());
//                            Log.d(TAG, response.body().getMessages()[0].getRemainingBalance());
//                            Log.d(TAG, response.body().getMessages()[0].getMessagePrice());
//                            Log.d(TAG, response.body().getMessages()[0].getNetwork());
//                        }
                        db.insert(message);
                        sendResponse("Message sent successfully");
                    } else {
                        sendResponse("Failed");

                    }

                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.e(TAG, e.getLocalizedMessage());
                    sendResponse(e.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(Call<MessageResponse> call, Throwable t) {
//                Log.e(TAG, t.getLocalizedMessage());
                sendResponse(t.getLocalizedMessage());
            }
        });
    }

    private void sendResponse(String response) {
        if (view == null)
            return;
        view.onResponse(response);

    }

}
