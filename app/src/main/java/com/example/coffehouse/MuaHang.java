package com.example.coffehouse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MuaHang extends AppCompatActivity {
    int minteger=0;
    ImageView giamsoluong_118,tangsoluong_118;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muahang);
        giamsoluong_118=(ImageView) findViewById(R.id.giamsoluong_118);
        giamsoluong_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGiam();
            }

        });
        tangsoluong_118=(ImageView) findViewById(R.id.tangsoluong_118);
        tangsoluong_118.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTang();
            }

        });
    }
    public void openTang(){
        minteger=minteger+1;
        display(minteger);
    }
    public void openGiam(){
        minteger=minteger-1;
        display(minteger);
    }
    public void display(int number){
        TextView displayInteger=(TextView) findViewById(R.id.number_118);
        displayInteger.setText(""+number);
    }

}