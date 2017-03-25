package com.example.matthew.expandablelistviewtesting;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    private static String[] groupData = {"  Phone Died", "  1%", "  2%", "  3%", "  4%", "  5%", "  6%", "  10%", "  15%"};
    private static String[] childData = {"*Click me to make a custom message!*",
                                         "*Click me to make a custom message!*",
                                         "*Click me to make a custom message!*",
                                         "*Click me to make a custom message!*",
                                         "*Click me to make a custom message!*",
                                         "*Click me to make a custom message!*",
                                         "*Click me to make a custom message!*",
                                         "*Click me to make a custom message!*",
                                         "*Click me to make a custom message!*"};
    private ExpandableListView expandableListView;
    public int curSelectedGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView1);
        expandableListView.setAdapter(new ExpandableListAdapterClass(context, this, groupData, childData));
        handleExpandPermissions();
    }

    public void handleExpandPermissions() {
        CheckChangeExpListViewReference.expandableListView = expandableListView;
        expandableListView.setOnGroupExpandListener(new OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                curSelectedGroup = groupPosition;
                HashMap<Long, Boolean> checkboxMapAdapter = ExpandableListAdapterClass.checkboxMap;
                boolean expand = false;
                ArrayList<Long> keys = new ArrayList<Long>();
                ArrayList<Boolean> values = new ArrayList<Boolean>();
                // searches the hasmap of checked or not checked to see if the groupPosition's checkbox value is checked or not
                // if not then we collapse the view on expand
                for (HashMap.Entry<Long, Boolean> e : checkboxMapAdapter.entrySet()) {
                    keys.add(e.getKey());
                    values.add(e.getValue());
                    if (e.getKey().intValue() == groupPosition) {
                        expand = e.getValue();
                        //break;
                    }
                }
                if (!expand) {
                    expandableListView.collapseGroup(groupPosition);
                }

                //// TODO: 2/7/2016 collect all non checked groupPositions and toss in an array, from there restrict collapsing if a groupposition is clicked that is within that array
                for (int i = 0; i < groupData.length; i++) {
                    if (i != groupPosition)
                        expandableListView.collapseGroup(i);
                }
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                showDialog();
                return false;
            }
        });


    }

    public void showDialog(){
        FragmentManager fm = getSupportFragmentManager();
        CustomDialogFragment editNameDialog = CustomDialogFragment.newInstance("Title");
        editNameDialog.show(fm, "fragment_edit_name");
    }

    public void updateInterface(){
        if (CustomDialogFragment.messageText != null) {
            ExpandableListAdapterClass.totalChildData[curSelectedGroup] = "Custom Message: " + CustomDialogFragment.messageText;
        }
        expandableListView.collapseGroup(curSelectedGroup);
        expandableListView.expandGroup(curSelectedGroup);
    }

    public static void CollapseUncheckedGroupOnUncheck(int collapseGroup, boolean collapse){
        ExpandableListView thisMethodExpLV  = CheckChangeExpListViewReference.expandableListView;

        if(collapse){
            thisMethodExpLV.collapseGroup(collapseGroup);
        }
    }



    }


