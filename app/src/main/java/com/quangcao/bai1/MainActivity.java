package com.quangcao.bai1;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
//  http://i64.tinypic.com/28vaq8k.png


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btn_Cach1(View view){
        startActivity(new Intent(this , Cach1Activity.class) );
    }

    public void btn_Cach2(View view){
        startActivity(new Intent(this , Cach2Activity.class) );
    }

    public void btn_Cach3(View view){
        startActivity(new Intent(this , Cach3Activity.class) );
    }
}