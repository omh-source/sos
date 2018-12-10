package com.example.omkar.retrapstep3;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.widget.EditText;

public class smsexp extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS = 0;
    Button sendBtn;
    EditText txtphoneNo;
    EditText txtphoneNo2;
    EditText txtMessage;
    String phoneNo;
    String message;
    String senderNo;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsexp);

        sendBtn = (Button) findViewById(R.id.button29);
        txtphoneNo = (EditText) findViewById(R.id.plain_text_input);
        txtphoneNo2 = (EditText) findViewById(R.id.plain_text_input2);
//Gets Edittexts of the phone number entries and enter button
        sendBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendSMSMessage();
            }
        });
    }

    public void backwego(View view) {
//Sends you back to the main menu when clicked
        textView1 = (TextView) findViewById(view.getId());

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(smsexp.this, Menu.class));
            }
        });
    }


    protected void sendSMSMessage() {
        phoneNo = txtphoneNo.getText().toString();
        senderNo = txtphoneNo2.getText().toString();
        //Gets both phone numbers
        message = "Hi, you were invited for a game of SOS!";
        Log.e("reciever=", phoneNo);
        Log.e("sender=", senderNo);
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
//Gets permissions for sending SMS(prompts user)
                Log.i("if brack,", "");
            } else {
                Log.i("else brack,", "");
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSIONS_REQUEST_SEND_SMS);
            }
        }
        sendSMS();
        Log.i("defaults to no brack,", "");
    }

    protected void sendSMS() {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address", new String(phoneNo));
        smsIntent.putExtra("sms_body", message);

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(smsexp.this,
                    "SMS failed, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        Log.e("requestcode", Integer.toString(requestCode));
        Log.e("perms", permissions.toString());
        Log.e("grantresults", grantResults.toString());

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_SEND_SMS: {

                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }


    public void saiv(View view) {
        sendBtn = (Button) findViewById(R.id.button29);
        txtphoneNo = (EditText) findViewById(R.id.plain_text_input);
        txtphoneNo2 = (EditText) findViewById(R.id.plain_text_input2);

        SmsManager smsManager = SmsManager.getDefault();

        phoneNo = txtphoneNo.getText().toString();
        senderNo = txtphoneNo2.getText().toString();
        //This re-assigns variables in case they aren't, and sends an SMS
        smsManager.sendTextMessage(new String(senderNo), null, "sms message", null, null);
        //Honestly, I have no clue why I keep the below 5 lines.
        EditText x = (EditText) findViewById(R.id.plain_text_input);
        Editable y = x.getText();
        Log.i("failed at saiv", "");
        x.setText("Taxi.", null);
        String str = x.getText().toString();
    }

}
//This code was excerpted from tutorialspoint.com and modified to work with this app