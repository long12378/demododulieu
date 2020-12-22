package com.example.coffehouse.TaiKhoan.ThongTinThanhVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.coffehouse.R;
import com.example.coffehouse.TaiKhoan.TaiKhoanFragment;

public class XemThongTinThanhVien extends AppCompatActivity {
    ImageView thoat4_118;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_thong_tin_thanh_vien);
        thoat4_118=findViewById(R.id.thoat4_118);
        thoat4_118.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openTaiKhoanFragment();
            }
        });
    }
    public void openTaiKhoanFragment(){
        Intent intent=new Intent(XemThongTinThanhVien.this, TaiKhoanFragment.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
}