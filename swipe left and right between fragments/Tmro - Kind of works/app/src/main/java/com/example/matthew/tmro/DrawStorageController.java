package com.example.matthew.tmro;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class DrawStorageController extends Fragment {


    // newInstance constructor for creating fragment with arguments
    public static DrawStorageController newInstance() {
        DrawStorageController fragmentFirst = new DrawStorageController();
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.draw_storage, container, false);
        return view;
    }
}
