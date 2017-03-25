package com.example.matthew.customgallery;

import android.content.*;
import android.util.*;
import android.view.*;
import android.widget.*;

public class CustomGalleryImageAdapter extends BaseAdapter {
    private Context mContext;
    private ImageView image;
    private LayoutInflater mInflater;
    private int count;

    private int[] mImageID = { R.drawable.color_1, R.drawable.color_2, R.drawable.color_3, R.drawable.color_4, R.drawable.color_5, R.drawable.color_1,
            R.drawable.color_2, R.drawable.color_3, R.drawable.color_4, R.drawable.color_5 };

    public CustomGalleryImageAdapter(Context c) {
        mContext = c;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        count = mImageID.length;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View mview = convertView;

        if (mview == null) {
            mview = mInflater.inflate(R.layout.gallery, null);
        }

        image = (ImageView) mview.findViewById(R.id.image);

        image.setBackgroundResource(mImageID[position]);

        return mview;
    }

}
