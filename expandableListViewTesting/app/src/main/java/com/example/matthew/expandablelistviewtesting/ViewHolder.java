package com.example.matthew.expandablelistviewtesting;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
    public TextView text;
    public CheckBox checkbox;
    public ViewHolder(View v) {
        this.text = (TextView)v.findViewById(R.id.text1);
        this.checkbox = (CheckBox)v.findViewById(R.id.cbx1);;
    }

}