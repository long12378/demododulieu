package com.example.btthandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper {
    public static final String TAG = "SQLite";
    public static final String DATABASE_NAME = "coffee";
    public static int DATABASE_VERSION = 1;
    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,"database.onCreate ...");
        String script = "CREATE TABLE IF NOT EXISTS caphe1(Id INTEGER PRIMARY KEY AUTOINCREMENT, TENSP TEXT, GIA TEXT, HINHANH TEXT)";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG,"database.onUpgrade ...");
        db.execSQL("DROP TABLE IF EXISTS caphe1");
        onCreate(db);
    }
    public int getcaphe1count(){
        Log.i(TAG,"database.getcaphe1count ...");
        String countquery = "SELECT * FROM caphe1";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countquery,null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public void createdefaultdataifnotexists(){
        Log.i(TAG,"database.createdefaultdataifnotexists...");
        SQLiteDatabase db = getWritableDatabase();
        int count = this.getcaphe1count();
        if(count == 0){
            String sql = "INSERT INTO caphe1 VALUES(NULL,'Cà phê đen','30000','phobien1')";
            db.execSQL(sql);
            sql = "INSERT INTO caphe1 VALUES(NULL,'cà phê lúa mạch đá xay','40000','phobien2')";
            db.execSQL(sql);
            sql = "INSERT INTO caphe1 VALUES(NULL,'sô cô la lúa mạch đá xay','50000','phobien3')";
            db.execSQL(sql);
            sql = "INSERT INTO caphe1 VALUES(NULL,'bạc xỉu','30000','phobien4')";
            db.execSQL(sql);
        }
    }
    public List<sanpham> getallsanpham(){
        Log.i(TAG,"database.getallsanpham ...");
        List<sanpham> spList = new ArrayList<sanpham>();
        String selectquery = "SELECT * FROM caphe1";
        SQLiteDatabase db  = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectquery,null);
        if(cursor.moveToFirst()){
            do{
                sanpham sp = new sanpham();
                sp.setId(cursor.getInt(0));
                sp.setTensp(cursor.getString(1));
                sp.setGia(cursor.getString(2));
                sp.setHinhanh(cursor.getString(3));
                spList.add(sp);
            }
            while(cursor.moveToNext());
        }
        return spList;
    }
}
