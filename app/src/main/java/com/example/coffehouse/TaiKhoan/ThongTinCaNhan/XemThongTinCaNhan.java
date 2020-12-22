package com.example.coffehouse.TaiKhoan.ThongTinCaNhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.coffehouse.NhapSoDienThoai;
import com.example.coffehouse.R;
import com.example.coffehouse.TaiKhoan.TaiKhoanFragment;

public class XemThongTinCaNhan extends AppCompatActivity {
    ImageView thoat_118;
    TextView txt_doithongtin_118;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //1. Nút thoát: quay về trang TaiKhoanFragment
        setContentView(R.layout.activity_xem_thong_tin_ca_nhan);
        thoat_118=findViewById(R.id.thoat_118);
        thoat_118.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openTaiKhoanFragment();
            }
        });
        //2. Nút đổi thông tin, chuyển sang trang SuaThongTin
        txt_doithongtin_118=findViewById(R.id.txt_doithongtin_118);
        txt_doithongtin_118.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openSuaThongTin();
            }
        });
    }
    //1
    public void openTaiKhoanFragment(){
        Intent intent=new Intent(XemThongTinCaNhan.this, TaiKhoanFragment.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
    }
    //2
    public void openSuaThongTin(){
        Intent intent = new Intent(this, SuaThongTin.class);
        startActivity(intent);
        finish();
    }
}