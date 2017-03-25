package com.example.matthew.tmro;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class DrawController extends Fragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener  {

    private DrawingView drawView;
    private TextView curDate;
    private ImageButton eraseBtn, saveBtn, drawBtn, newBtn;
    private float smallBrush, mediumBrush, largeBrush;

    public static DrawController newInstance(){
        DrawController drCntroller = new DrawController();
        return drCntroller;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    // Inflate the view for the fragment based on layout XML
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drawing_activity_main, container, false);
        drawingSetup(view);
        return view;
    }


    public void drawingSetup(View view){

        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);

        curDate = (TextView)view.findViewById(R.id.textViewDatePicker);
        String stringDate = getStringDate(0,0,0);
        curDate.setText(stringDate);
        drawView = (DrawingView)view.findViewById(R.id.drawing);
        drawView.setBrushSize(smallBrush);

        drawBtn = (ImageButton)view.findViewById(R.id.draw_btn);
        drawBtn.setOnClickListener(this);

        eraseBtn = (ImageButton)view.findViewById(R.id.erase_btn);
        eraseBtn.setOnClickListener(this);

        newBtn = (ImageButton)view.findViewById(R.id.new_btn);
        newBtn.setOnClickListener(this);


        curDate.setOnClickListener(this);

    }

    private String getStringDate(int y, int m, int d){
        Calendar c = Calendar.getInstance();
        int year = -1;
        int month = -1;
        int day = -1;
        String monthName = "";
        String formatDate = "";

        if(y== 0 & m== 0 & d == 0){
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }
        else {
            year = y;
            month = m;
            day  = d;
        }



        switch (month){
            case 0:
                monthName = "Jan";
                break;
            case 1:
                monthName = "Feb";
                break;
            case 2:
                monthName = "Mar";
                break;
            case 3:
                monthName = "Apr";
                break;
            case 4:
                monthName = "May";
                break;
            case 5:
                monthName = "Jun";
                break;
            case 6:
                monthName = "Jul";
                break;
            case 7:
                monthName = "Aug";
                break;
            case 8:
                monthName = "Sept";
                break;
            case 9:
                monthName = "Oct";
                break;
            case 10:
                monthName = "Nov";
                break;
            case 11:
                monthName = "Dec";
                break;
        }

        formatDate = monthName + ", " + day + ", " + year;

        return formatDate;
    }

    public void onClick(View v) {

        if(v.getId()==R.id.draw_btn) {

            drawView.setBrushSize(smallBrush);
            //drawView.setLastBrushSize(smallBrush);
            drawView.setErase(false);
        }
        else if (v.getId() == R.id.erase_btn) {

            //switch to erase - choose size
            final Dialog brushDialog = new Dialog(getActivity());
            brushDialog.setTitle("Eraser size:");
            brushDialog.setContentView(R.layout.brush_chooser);

            ImageButton smallBtn = (ImageButton)brushDialog.findViewById(R.id.small_brush);
            smallBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(smallBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton mediumBtn = (ImageButton)brushDialog.findViewById(R.id.medium_brush);
            mediumBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(mediumBrush);
                    brushDialog.dismiss();
                }
            });
            ImageButton largeBtn = (ImageButton)brushDialog.findViewById(R.id.large_brush);
            largeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawView.setErase(true);
                    drawView.setBrushSize(largeBrush);
                    brushDialog.dismiss();
                }
            });

            brushDialog.show();
        }
        else if(v.getId() ==  R.id.new_btn){
            drawView.startNew();
        }
        else if(v.getId() ==  R.id.textViewDatePicker){
            Calendar myCalendar = Calendar.getInstance();
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, year, month, day);
            dialog.show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        curDate.setText(getStringDate(year, monthOfYear, dayOfMonth));
    }
}
