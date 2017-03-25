package com.example.matthew.customnumberpickerwidget;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button btnUp, btnDown;
    TextView textViewUp, textViewMid, textViewBottom;

    int nStart = 5;
    int nEnd = 250;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUp = (Button) findViewById(R.id.button1);
        btnDown = (Button) findViewById(R.id.button2);

        textViewUp = (TextView) findViewById(R.id.textView1);
        textViewMid = (TextView) findViewById(R.id.textView2);
        textViewBottom = (TextView) findViewById(R.id.textView3);

        textViewUp.setText("5");
        textViewMid.setText("6");
        textViewBottom.setText("7");

        btnUp.setOnClickListener(this);
        btnDown.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        String getString = String.valueOf(textViewMid.getText());
        int curent = Integer.parseInt(getString);
        if (v == btnUp) {
            if (curent < nEnd) {
                curent++;
                textViewUp.setText(String.valueOf(curent - 1));
                textViewMid.setText(String.valueOf(curent));
                textViewBottom.setText(String.valueOf(curent + 1));
            }

        }
        if (v == btnDown) {
            if (curent > nStart) {
                curent--;
                textViewUp.setText(String.valueOf(curent - 1));
                textViewMid.setText(String.valueOf(curent));
                textViewBottom.setText(String.valueOf(curent + 1));
            }
        }
    }
}