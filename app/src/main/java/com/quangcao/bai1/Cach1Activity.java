//package com.quangcao.bai1;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class Cach1Activity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_cach1);
//    }
//}
package com.quangcao.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Cach1Activity extends AppCompatActivity implements XulyInterface,
        View.OnClickListener {
//  http://i64.tinypic.com/28vaq8k.png

    Button btn_xuly;
    ImageView imv_anh;
    TextView tv_message;

    Handler handler = new Handler();

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
        new CustomAsynTask(this , Cach1Activity.this).execute("http://i64.tinypic.com/28vaq8k.png");
    }

    @Override
    public void onLoadBitMap(Bitmap bitmap) {
        if (bitmap != null){
            imv_anh.setImageBitmap(bitmap);
            tv_message.setText("Load ảnh thành công");
        }
    }

    @Override
    public void onError() {
        tv_message.setText("Lỗi load dữ liệu ( lỗi lấy ảnh )");
    }

}