//package com.quangcao.bai1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class Cach2Activity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cach2);
//    }
//}
package com.quangcao.bai1;


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

public class Cach2Activity extends AppCompatActivity implements View.OnClickListener {
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
        new TBAsyn().execute("http://i64.tinypic.com/28vaq8k.png");
    }

    // sử dụng lớp nội
    public class TBAsyn extends AsyncTask<String , Void , Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
//            Lấy ảnh về từ trang web ( theo đường dẫn )
                return BitmapFactory.decodeStream( (InputStream) new URL(strings[0]).getContent());
            } catch (Exception ex){
                Log.e("--------------- Error" , ex.toString() );
            }
            return null;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (bitmap != null){
                imv_anh.setImageBitmap(bitmap);
                tv_message.setText("Load ảnh thành công");
            } else {
                tv_message.setText("Lỗi load và lấy ảnh !");
            }
        }

    }

}