package com.example.btthandroid;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<sanpham> spList;
    GridView grid;
    adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database db = new database(this);
        db.createdefaultdataifnotexists();
        grid = (GridView) findViewById(R.id.gridcaphe);
        spList = db.getallsanpham();
        adapter = new adapter(this,spList,R.layout.itemgrid);
        grid.setAdapter(adapter);
    }
}
