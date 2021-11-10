package com.quangcao.bai1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.InputStream;
import java.net.URL;

public class CustomAsynTask extends AsyncTask<String , Void , Bitmap> {
    //    AsyncTask<input , Progress , output>
    private XulyInterface xulyInterface;

    public CustomAsynTask(XulyInterface xulyInterface , Context context) {
        this.xulyInterface = xulyInterface;
    }

    //    Xử lí dữ liệu đầu vào
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

//    Xử lí dữ liệu đầu ra
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        if (bitmap != null){
//            truyền vào tham số cho hàm đã định nghĩa ( hàm onLoadBitMap trong XulyInterface )
            xulyInterface.onLoadBitMap(bitmap); // trả kết quả về cho Interface
        } else {
            xulyInterface.onError(); // nếu lỗi cũng trả kết quả về cho Interface
        }
    }

}
