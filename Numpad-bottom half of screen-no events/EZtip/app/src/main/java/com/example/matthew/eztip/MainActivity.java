package com.example.matthew.eztip;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String userEntry = "";
    private TextView userEntryDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userEntryDisplay = (TextView) findViewById(R.id.numClicks);
        setViews();

    }

    private void setViews(){

        TextView key1 = (TextView) findViewById(R.id.key_1);
        TextView key2 = (TextView) findViewById(R.id.key_2);
        TextView key3 = (TextView) findViewById(R.id.key_3);
        TextView key4 = (TextView) findViewById(R.id.key_4);
        TextView key5 = (TextView) findViewById(R.id.key_5);
        TextView key6 = (TextView) findViewById(R.id.key_6);
        TextView key7 = (TextView) findViewById(R.id.key_7);
        TextView key8 = (TextView) findViewById(R.id.key_8);
        TextView key9 = (TextView) findViewById(R.id.key_9);
        TextView key0 = (TextView) findViewById(R.id.key_0);

        TextView keyDecimal = (TextView) findViewById(R.id.key_decimal);
        TextView keyBack = (TextView) findViewById(R.id.key_backspace);
        TextView keyClearAll = (TextView) findViewById(R.id.key_clearall);
        TextView keyEnter = (TextView) findViewById(R.id.key_enter);


        key1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        key0.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        keyDecimal.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });

        keyBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        keyClearAll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });
        keyEnter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                onCustNumPadClick(v.getId());
                userEntryDisplay.setText(userEntry);
            }
        });

    }

    private void onCustNumPadClick(int key) {
        switch (key) {
            case R.id.key_0:
                userEntry += "0";
                break;
            case R.id.key_1:
                userEntry += "1";
                break;
            case R.id.key_2:
                userEntry += "2";
                break;
            case R.id.key_3:
                userEntry += "3";
                break;
            case R.id.key_4:
                userEntry += "4";
                break;
            case R.id.key_5:
                userEntry += "5";
                break;
            case R.id.key_6:
                userEntry += "6";
                break;
            case R.id.key_7:
                userEntry += "7";
                break;
            case R.id.key_8:
                userEntry += "8";
                break;
            case R.id.key_9:
                userEntry += "9";
                break;
            case R.id.key_decimal:
                userEntry += ".";
                break;
            case R.id.key_enter:{
                //TextView nmClicks = (TextView) findViewById(R.id.numClicks);
                //nmClicks.setText(mEtPassword.toString());
                userEntry += "E";
                break;
            }
            case R.id.key_clearall:
                userEntry = "";
                break;
            case R.id.key_backspace: {
                userEntry = userEntry.substring(0, userEntry.length()-1);
                break;
                }
            }

        }

}
