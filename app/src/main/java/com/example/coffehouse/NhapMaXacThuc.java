package com.example.coffehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NhapMaXacThuc extends AppCompatActivity {
    ImageView quaylai2_nhapsodienthoai_118;
    EditText nhapmaxacthuc_118;
    Button btnmaxacthuc_118;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_ma_xac_thuc);
        //1. Nút quay lại
        ImageView quaylai2_nhapsodienthoai_118=(ImageView) findViewById(R.id.quaylai2_nhapsodienthoai_118);
        quaylai2_nhapsodienthoai_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNhapSoDienThoai();
            }
        });
        //2. Nút button
        nhapmaxacthuc_118=(EditText) findViewById(R.id.nhapmaxacthuc_118);
        btnmaxacthuc_118=(Button) findViewById(R.id.btnmaxacthuc_118);
        btnmaxacthuc_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str2 = nhapmaxacthuc_118.getText().toString();
                if(str2.length()==0) {
                    Toast.makeText(NhapMaXacThuc.this, "Bạn chưa điền. Mời nhập lại", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(NhapMaXacThuc.this, "Tiếp tục",Toast.LENGTH_LONG).show();
                    openMainActivity();
                }
            }
        });





//        btnmaxacthuc = (Button) findViewById(R.id.btnmaxacthuc);
//        btnmaxacthuc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openMainActivity();
//            }
//        });
    }
    //1.
    public void openNhapSoDienThoai() {
        Intent intent = new Intent(this, NhapSoDienThoai.class);
        startActivity(intent);
        finish();
    }
    //2.
    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}