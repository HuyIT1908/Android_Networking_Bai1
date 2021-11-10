//package com.quangcao.bai1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class Cach3Activity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cach3);
//    }
//}
package com.quangcao.bai1;


import android.app.ProgressDialog;
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

public class Cach3Activity extends AppCompatActivity implements View.OnClickListener {
//  http://i64.tinypic.com/28vaq8k.png

    Button btn_xuly;
    ImageView imv_anh;
    TextView tv_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cach1);

        tv_message = findViewById(R.id.tv_message);
        imv_anh = findViewById(R.id.imv_anh);
        btn_xuly = findViewById(R.id.btn_xuly);

        btn_xuly.setOnClickListener(this);
    }

    //    khi mà nhấn vào nut btn_xuly thì gọi đến hàm onClick này
    @Override
    public void onClick(View view) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = load_Image("http://i64.tinypic.com/28vaq8k.png");

                imv_anh.post(new Runnable() {
                    @Override
                    public void run() {
                        if (bitmap != null){
                            imv_anh.setImageBitmap(bitmap);
                            tv_message.setText("Load ảnh thành công");
                        } else {
                            tv_message.setText("Lỗi load và lấy ảnh !");
                        }
                    }
                });
            }
        });
        thread.start();
    }

    private Bitmap load_Image(String link){
        Bitmap bitmap = null;
        URL url;
        try {
            url = new URL(link);
            bitmap = BitmapFactory.decodeStream( url.openConnection().getInputStream() );

            return bitmap;
        } catch (Exception ex){
            Log.e("--------------- Error" , ex.toString() );
        }

        return bitmap;
    }

}