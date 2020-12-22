package com.example.coffehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    EditText nhapsodienthoai2_118;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nhapsodienthoai2_118 = (EditText) findViewById(R.id.nhapsodienthoai2_118);
        nhapsodienthoai2_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNhapSoDienThoai();
            }
        });
    }
    public void openNhapSoDienThoai() {
        Intent intent = new Intent(this, NhapSoDienThoai.class);
        startActivity(intent);
        finish();
    }
}