package com.venom.assignment.contact.view;


import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.venom.assignment.contact.R;
import com.venom.assignment.contact.support.BaseActivity;
import com.venom.assignment.contact.model.Constants;
import com.venom.assignment.contact.model.Contact;

public class ContactInfoActivity extends BaseActivity {


    private Contact contact;
    private Button mSendMessage;
    private TextView mContactDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        contact = getIntent().getParcelableExtra(Constants.contact);
        if (contact == null) {
            onBackPressed();
            return;
        }
        mSendMessage = findViewById(R.id.send_message);
        mContactDetails = findViewById(R.id.contact_details);
        mContactDetails.setText(Html.fromHtml("<big><b>" + contact.getFirst_name()+" "+contact.getLast_name() + "</b></big><br><br>" +
                "Mobile Number : " + contact.getMobile() + "<br><br>"
        ));
        mSendMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putParcelable(Constants.contact, contact);
                startActivity(NewMessageActivity.class, bundle);
            }
        });
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
        return R.layout.activity_contact_info;
    }

}
