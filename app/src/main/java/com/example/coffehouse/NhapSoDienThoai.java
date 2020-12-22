package com.example.coffehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class NhapSoDienThoai extends AppCompatActivity {
    ImageView quaylai_nhapsodienthoai_118;
    EditText nhapsodienthoai3_118;
    Button btntieptuc_118;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhap_so_dien_thoai);

        quaylai_nhapsodienthoai_118 = (ImageView) findViewById(R.id.quaylai_nhapsodienthoai_118);
        quaylai_nhapsodienthoai_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLogin();
            }
        });
        nhapsodienthoai3_118 = (EditText) findViewById(R.id.nhapsodienthoai3_118);
        btntieptuc_118 = (Button) findViewById(R.id.btntieptuc_118);
        btntieptuc_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = nhapsodienthoai3_118.getText().toString();
                if(str1.length()==0){
                    Toast.makeText(NhapSoDienThoai.this, "Bạn chưa điền. Mời nhập lại",Toast.LENGTH_LONG).show();
                }else if(str1.length()>10){
                    Toast.makeText(NhapSoDienThoai.this, "Không được nhập trên 10 kí tự",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(NhapSoDienThoai.this, "Tiếp tục",Toast.LENGTH_LONG).show();
                    openNhapMaXacThuc();
                }
//                String str1 = nhapsodienthoai3_118.getText().toString();
//                if (isNumeric(str1)== true) {
//                     if (str1.length() == 0) {
//                         Toast.makeText(NhapSoDienThoai.this, "Bạn chưa điền. Mời nhập lại", Toast.LENGTH_LONG).show();
//                     } else if (str1.length() > 10) {
//                         Toast.makeText(NhapSoDienThoai.this, "Không được nhập trên 10 kí tự", Toast.LENGTH_LONG).show();
//                     } else {
//                         Toast.makeText(NhapSoDienThoai.this, "Tiếp tục", Toast.LENGTH_LONG).show();
//                         openNhapMaXacThuc();
//                     }
//            } else {
//                Toast.makeText(NhapSoDienThoai.this, "Không được nhập chữ", Toast.LENGTH_LONG).show();
//            }
        }
        });
    }

//    public static boolean isNumeric(String str1) {
//        try {
//            Integer.parseInt(str1);
//            return true;
//        } catch (NumberFormatException e) {
//            return false;
//        }
//    }
    public void openLogin() {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
    public void openNhapMaXacThuc(){
        Intent intent = new Intent(this, NhapMaXacThuc.class);
        startActivity(intent);
        finish();
    }

}