package com.example.matthew.catchshutdowntest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        test = (Button) findViewById(R.id.button);
        test.setOnClickListener(this);

        // INITIALIZE RECEIVER
        IntentFilter filter = new IntentFilter(Intent.ACTION_SHUTDOWN);
        BroadcastReceiver mReceiver = new ShutDownReceiver();
        registerReceiver(mReceiver, filter);
        // YOUR CODE
    }

    public class ShutDownReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            if (intent.getAction().equals(Intent.ACTION_SHUTDOWN))
            {
                sendEmergencyText();
            }
        }
    }

    public void sendEmergencyText(){
        String phoneNumber = "5556";
        String message = "test!!!";

        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
    }

    @Override
    public void onClick(View v) {
        if (v == test){
            sendEmergencyText();
        }

        return;
    }
}
