package com.example.matthew.sqlliteexample;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    SQLiteDatabase db;

    private String directoryPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/sqlTest";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File storageDirectoryPath = new File(directoryPath);
        if (!storageDirectoryPath.exists()) {
            storageDirectoryPath.mkdir();
        }

        imageView1 = (ImageView) this.findViewById(R.id.imageView1);
        db = this.openOrCreateDatabase("test.db", Context.MODE_PRIVATE, null);
        db.execSQL("create table if not exists tb (a blob)");


    }

    public void saveImage(View view){
        String x = "";
        try {
            FileInputStream fis = new FileInputStream(directoryPath+"/Db.png");
            byte[] image = new byte[fis.available()];
            fis.read(image);

            ContentValues values = new ContentValues();
            values.put("a", image);

            db.insert("tb", null, values);

            fis.close();


            Toast.makeText(this, "insert scuccess", Toast.LENGTH_SHORT).show();



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void getImage(View view){
         Cursor c = db.rawQuery("select * from tb", null);
        if(c.moveToNext()){
            byte[] image =  c.getBlob(0);
            Bitmap bmp = BitmapFactory.decodeByteArray(image, 0,  image.length);
            imageView1.setImageBitmap(bmp);
            Toast.makeText(this, "get scuccess", Toast.LENGTH_SHORT).show();
        }
    }
}
