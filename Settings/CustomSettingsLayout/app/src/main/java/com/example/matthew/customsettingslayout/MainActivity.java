package com.example.matthew.customsettingslayout;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

import Helper.AppGlobalVars;

public class MainActivity extends Activity {

    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> percentPrefCollection;
    ExpandableListView expListView;
    ExpandableListAdapter expListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createGroupList();

        createCollection();

        expListView = (ExpandableListView) findViewById(R.id.Percent_list);
        expListAdapter = new ExpandableListAdapt(this, groupList, percentPrefCollection);
        expListView.setAdapter(expListAdapter);

        setupGroupNdChildListeners(expListView);

    }

    private void setupGroupNdChildListeners(ExpandableListView expListView ){
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                                        int groupPosition, long id) {
                 Toast.makeText(getApplicationContext(),
                 "Group Clicked " ,
                 Toast.LENGTH_SHORT).show();

                return false;
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), " Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        " Collapsed",
                        Toast.LENGTH_SHORT).show();

            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
            Toast.makeText(
                    getApplicationContext(),
                    "Child clicked", Toast.LENGTH_SHORT)
                    .show();
                return false;
            }
        });
    }

    private void createGroupList() {
        groupList = new ArrayList<String>();
        for(String percentText: AppGlobalVars.listOfPercents){
            groupList.add(percentText);
        }
    }

    private void createCollection() {
        childList = new ArrayList<String>();
        String customMessageTitle = "*Create Custom Message*" ;

        percentPrefCollection = new LinkedHashMap<String, List<String>>();
        childList.add(customMessageTitle);
        for (String percentTextsInGroupList : groupList) {
            percentPrefCollection.put(percentTextsInGroupList, childList);
        }

    }
}