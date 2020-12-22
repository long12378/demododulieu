package com.example.coffehouse.TaiKhoan.ThongTinCaNhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.coffehouse.R;

public class SuaThongTin extends AppCompatActivity {
    ImageView thoat2_118;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sua_thong_tin);
        //1. Nút thoát nhảy về trang XemThongTinCaNhan
        thoat2_118=findViewById(R.id.thoat2_118);
        thoat2_118.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openXemThongTinCaNhan();
            }
        });
    }
    //1
    public void openXemThongTinCaNhan(){
        Intent intent = new Intent(this, XemThongTinCaNhan.class);
        startActivity(intent);
        finish();
    }
}