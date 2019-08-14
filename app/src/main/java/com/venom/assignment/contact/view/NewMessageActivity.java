package com.venom.assignment.contact.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.venom.assignment.contact.R;
import com.venom.assignment.contact.model.Message;
import com.venom.assignment.contact.support.AppLogic;
import com.venom.assignment.contact.model.Constants;
import com.venom.assignment.contact.model.Contact;
import com.venom.assignment.contact.support.MVPActivity;
import com.venom.assignment.contact.presenter.NewMessagePresenter;

import java.util.Random;

import static com.venom.assignment.contact.model.Constants.HI;

public class NewMessageActivity extends MVPActivity<AppLogic.NewMessageLogic> implements AppLogic.NewMessageView {


    private Contact contact;
    private Button mSendMessage;
    private TextView mContactDetails;
    private EditText mContent;
    private ProgressDialog progressDialog;
    private String otp;

    @Override
    protected AppLogic.NewMessageLogic createPresenter() {
        return new NewMessagePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        contact = getIntent().getParcelableExtra(Constants.contact);
        if (contact == null) {
            onBackPressed();
            return;
        }
        otp=String.valueOf(new Random().nextInt(6));
        mSendMessage = findViewById(R.id.send_message);
        mContactDetails = findViewById(R.id.contact_details);
        mContent = findViewById(R.id.content);
        mContactDetails.setText(Html.fromHtml("<big><b>Send To : </b></big>" +
                contact.getFirst_name()+" "+contact.getLast_name()+ " - "+contact.getMobile() + "<br><br>"
        ));
        mSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateAllFields()) {
                    showProgrressDialog();
                    presenter.sendMessage(new Message(contact.getFirst_name()+" "+contact.getLast_name(),
                            contact.getMobile(),otp,mContent.getText().toString().concat(HI).concat(otp)));
                }

            }
        });
    }

    private void showProgrressDialog() {
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Sending message, please wait.");
        progressDialog.show();
    }
    private void dismissProgrressDialog() {
        if(progressDialog==null || !progressDialog.isShowing())
            return;
        progressDialog.dismiss();
    }

    private boolean validateAllFields() {
        if (!Patterns.PHONE.matcher(contact.getMobile()).matches()) {
            showToast("Please enter valid number");
            return false;
        } else if (mContent.length() == 0) {
            mContent.setError("The message is empty");
            return false;
        } else {
            return true;
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_new_message;
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }

    @Override
    public void onResponse(String response) {
        dismissProgrressDialog();
        showToast(response);
        onBackPressed();
    }
}
