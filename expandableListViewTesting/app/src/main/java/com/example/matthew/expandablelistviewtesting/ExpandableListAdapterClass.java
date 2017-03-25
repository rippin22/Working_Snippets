package com.example.matthew.expandablelistviewtesting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListAdapter;

public class ExpandableListAdapterClass extends BaseExpandableListAdapter implements ExpandableListAdapter  {
    public Context context;
    private LayoutInflater ExpandableListViewLayoutInflater;
    public static String[] totalGroupData;
    public static String[] totalChildData;
    public CheckChangeExpListViewReference vcl;


    int _objInt;
    public static Boolean checked[] = new Boolean[1];

    public static HashMap<Long,Boolean> checkboxMap = new HashMap<Long,Boolean>();
    private static final int GROUP_ITEM_RESOURCE = R.layout.list_group;
    private static final int CHILD_ITEM_RESOURCE = R.layout.list_item;
    public String []check_string_array;

    public ExpandableListAdapterClass(Context context, Activity activity, String[] groupData, String[] childData ) {
        this.totalGroupData = groupData;
        this.totalChildData = childData;
        this.context = context;
        ExpandableListViewLayoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        _objInt = groupData.length;
        check_string_array = new String[_objInt];
        CheckMap();
    }
    public void CheckMap(){

        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        String buffer = null;

        for(int i=0; i<_objInt; i++){
            buffer = settings.getString(String.valueOf((int)i),"false");
            if(buffer.equals("false"))
                checkboxMap.put((long)i, false);
            else checkboxMap.put((long)i, true);
        }
    }

    public void setVCL(CheckChangeExpListViewReference datListener){
        this.vcl = datListener;
    }

    public class CheckListener implements OnCheckedChangeListener{

        long pos;
        public void setPosition(long p){
            pos = p;
        }

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            checkboxMap.put(pos, isChecked);
            if(isChecked == true){
                check_string_array[(int)pos] = "true";
            }
            else {
                check_string_array[(int) pos] = "false";
                MainActivity.CollapseUncheckedGroupOnUncheck((int)pos, true);
            }

            // save checkbox state of each group
            SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor preferencesEditor = settings.edit();
            preferencesEditor.putString(String.valueOf((int)pos), check_string_array[(int)pos]);
            preferencesEditor.commit();
        }



    }


    public String getChild(int groupPosition, int childPosition) {
        return totalChildData[groupPosition];
    }

    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        //return totalChildData.length;
        return 1;
    }

    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View v = convertView;
        String child = getChild(groupPosition, childPosition);
        if (child != null && childPosition < 1) {
            v = ExpandableListViewLayoutInflater.inflate(CHILD_ITEM_RESOURCE, null);
            ViewHolder holder = new ViewHolder(v);
            holder.text.setText(Html.fromHtml(child));

        }
        return v;
    }

    public String getGroup(int groupPosition) {
        return "group-" + groupPosition;
    }
    public int getGroupCount() {
        return totalGroupData.length;
    }
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View v = convertView;
        String group = null;
        long group_id = getGroupId(groupPosition);

        group = totalGroupData[(int)group_id];

        if (group != null) {
            v = ExpandableListViewLayoutInflater.inflate(GROUP_ITEM_RESOURCE, null);
            ViewHolder holder = new ViewHolder(v);

            // establish checkbox for groupview
            holder.text.setText(Html.fromHtml(group));
            holder.checkbox.setFocusable(false);
            CheckListener checkL = new CheckListener();
            checkL.setPosition(group_id);
            holder.checkbox.setOnCheckedChangeListener(checkL);
            holder.checkbox.setChecked(checkboxMap.get(group_id));
        }
        return v;
    }

    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
    public boolean hasStableIds() {
        return true;
    }


}
