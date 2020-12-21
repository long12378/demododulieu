package com.example.testsqlitewithgridview;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    database db;
    GridView caphee;
    ArrayList<caphe> capheArrayList;
    capheadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        caphee = (GridView) findViewById(R.id.gridphobien425);
        capheArrayList = new ArrayList<>();
        adapter = new capheadapter(this, R.layout.capheitem,capheArrayList);
        caphee.setAdapter(adapter);
        db = new database(this,"caphesqlite",null,1);
        db.QueryData("DROP TABLE IF EXISTS Caphehouse");
        db.QueryData("CREATE TABLE IF NOT EXISTS Caphehouse(Id INTEGER PRIMARY KEY AUTOINCREMENT, TENSP NVARCHAR(200), GIASP TEXT, HINHANH TEXT)");
        db.QueryData("INSERT INTO  Caphehouse VALUES(NULL, 'CAPPUCHINO', '300000', 'phobien1')");
        db.QueryData("INSERT INTO  Caphehouse VALUES(NULL, 'CAPHEDEN', '300000', 'phobien2')");
        db.QueryData("INSERT INTO  Caphehouse VALUES(NULL, 'BACXIU', 300000, 'phobien3')");
        Cursor datacaphe =   db.GetData("SELECT * FROM Caphehouse");
        while(datacaphe.moveToNext()){
            String ten = datacaphe.getString(1);
            int id = datacaphe.getInt(0);
            String gia = datacaphe.getString(2);
            String hinhanh = datacaphe.getString(3);
            capheArrayList.add(new caphe(id,ten,gia,hinhanh));
        }
        adapter.notifyDataSetChanged();
    }
}