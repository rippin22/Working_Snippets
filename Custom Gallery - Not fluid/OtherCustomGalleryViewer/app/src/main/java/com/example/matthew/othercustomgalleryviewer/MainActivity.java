package com.example.matthew.othercustomgalleryviewer;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private CustomPagerBase pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //change cardslayout to generally the main layout with a realative layout in it
        // use the main layouts realative layout ID for the r.id.'urRelLayout'
        RelativeLayout cardsLayout = (RelativeLayout)findViewById(R.id.cardsLayout);

        //this is listed  below
        CustomAdapter adapter = new CustomAdapter(this);

        //keep custom pager base standard, we go this from importing sidebar&viewhelper
        //the "cardsLayout" will change to whatever you named it above
        pager = new CustomPagerBase(this, cardsLayout, adapter);
        //This starts at position 2 for visual  purposes
        pager.preparePager(2);

        //currently crashes if ther isn't an image to the far most right of the image list
        Button next = (Button)findViewById(R.id.next);
        Button prev = (Button)findViewById(R.id.previous);

        next.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                pager.performNextPage();
            }
        });
        prev.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                pager.performPreviousPage();
            }
        });
    }

    public class CustomAdapter extends CustomPagerAdapter{

        public CustomAdapter(Context context) {
            super(context);
        }

        @Override
        public View getView(int position, View convertView) {
            View tempView = convertView;
            if(tempView == null){
                LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                tempView = inflater.inflate(R.layout.single_card_fragment, null, false);
            }
            ImageView cardImage = (ImageView)tempView.findViewById(R.id.cardImage);
            ImageView cardImage1 = (ImageView)tempView.findViewById(R.id.cardImage2);
            ImageView cardImage2 = (ImageView)tempView.findViewById(R.id.cardImage);
            ImageView cardImage3 = (ImageView)tempView.findViewById(R.id.cardImage2);

            cardImage.setImageDrawable(MainActivity.this.getResources().getDrawable(R.drawable.card_image));
            cardImage1.setImageDrawable(MainActivity.this.getResources().getDrawable(R.drawable.card_image2));
            cardImage2.setImageDrawable(MainActivity.this.getResources().getDrawable(R.drawable.card_image));
            cardImage3.setImageDrawable(MainActivity.this.getResources().getDrawable(R.drawable.card_image2));

            return tempView;
        }

        @Override
        public int dataCount() {
            return 5;
        }

    }
}