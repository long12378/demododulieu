package com.example.coffehouse.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.coffehouse.DatHang.TabDatHang.sanpham;

import java.util.ArrayList;
import java.util.List;

public class database extends SQLiteOpenHelper {
    private static final String TAG = "SQLite";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "coffeehouse";

    public database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void QueryData(String sql){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG, "database.onCreate ...");
        String script = "CREATE TABLE IF NOT EXISTS sanpham(Id INTEGER PRIMARY KEY AUTOINCREMENT, PHOBIEN INTEGER, LOAISP TEXT, TENSP TEXT, GIASP TEXT, HINHANH TEXT)";
        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i(TAG, "database.onUpgrade ... ");
        db.execSQL("DROP TABLE IF EXISTS sanpham");
        onCreate(db);
    }
    public int getCapheCount(){
        Log.i(TAG ,"database.getCapheCount ... " );
        String countQuery = "SELECT * FROM sanpham";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public void createDefaultsanphamIfNeed(){
        SQLiteDatabase db = getWritableDatabase();
        int count = this.getCapheCount();
        if(count == 0){
//            caphe caphe1 = new caphe(1,"Cappuchino", "3000000","phobien1");
//            caphe caphe2 = new caphe(2,"Ca phe da", "3000000","phobien2");
//            caphe caphe3 = new caphe(2,"Bac xiu", "3000000","phobien3");
//            this.AddCaphe(caphe1);
//            this.AddCaphe(caphe2);
//            this.AddCaphe(caphe3);
            String sql = "INSERT INTO  sanpham VALUES(NULL, 1,'douong' , 'Cà phê Lúa Mạch đá xay', '70000', 'phobien1')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,1, 'douong',  'Cà phê Lúa Mạch nóng', '300000', 'phobien2')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,1,'douong', 'Sôcôla Lúa Mạch đá xay', '300000', 'phobien3')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,1,'douong', 'Sôcôla Lúa Mạch nóng', '300000', 'phobien4')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,0,'douong', 'Sôcôla Lúa Mạch nóng', '300000', 'phobien5')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,1,'douong', 'Sôcôla Lúa Mạch nóng', '300000', 'phobien6')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,1,'douong', 'Trà sữa Mắc Ca Trân Châu Trắng', '300000', 'phobien7')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,1,'douong', 'Trà đào cam sả và mật ong', '300000', 'phobien8')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,0,'douong', 'Oolong Hạt Sen - Đá đặc biệt', '300000', 'phobien9')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,1,'douong', 'Trà Oolong Phúc Bồn Tử', '300000', 'phobien10')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,1,'doan', 'Macca Phủ Socola', '300000', 'phobien1')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,0,'doan', 'Mít sấy', '300000', 'doan2')";
            db.execSQL(sql);
            sql = "INSERT INTO  sanpham VALUES(NULL,0,'doan', 'Cơm cháy chà bông', '300000', 'doan3')";
            db.execSQL(sql);
        }

    }
    public List<sanpham> getAllsanpham() {
        Log.i(TAG, "database.getAllsanpham ... " );

        List<sanpham> pbList = new ArrayList<sanpham>();
        // Select All Query
        String selectQuery = "SELECT  * FROM sanpham";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                sanpham pb = new sanpham(100,3,"asdfsadfasdf","asdfsadfsadf","2223020320321","dcdcdcdcdcdcdc");
                pb.setId(cursor.getInt(0));
                pb.setPhobien(cursor.getInt(1));
                pb.setLoaisp(cursor.getString(2));
                pb.setTensp(cursor.getString(3));
                pb.setGia(cursor.getString(4));
                pb.setHinhanh(cursor.getString(5));
                // Adding note to list
                pbList.add(pb);
            } while (cursor.moveToNext());
        }

        // return note list
        return pbList;
    }
    public List<sanpham> getAllphobien() {
        Log.i(TAG, "database.getAllphobien ... " );

        List<sanpham> pbList = new ArrayList<sanpham>();
        // Select All Query
        String selectQuery = "SELECT  * FROM sanpham WHERE PHOBIEN = 1";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                sanpham pb = new sanpham(100,3,"asdfsadfasdf","asdfsadfsadf","2223020320321","dcdcdcdcdcdcdc");
                pb.setId(cursor.getInt(0));
                pb.setPhobien(cursor.getInt(1));
                pb.setLoaisp(cursor.getString(2));
                pb.setTensp(cursor.getString(3));
                pb.setGia(cursor.getString(4));
                pb.setHinhanh(cursor.getString(5));
                // Adding note to list
                pbList.add(pb);
            } while (cursor.moveToNext());
        }

        // return note list
        return pbList;
    }
    public List<sanpham> getAllcdouong() {
        Log.i(TAG, "database.getAlldouong ... " );

        List<sanpham> doList = new ArrayList<sanpham>();
        // Select All Query
        String selectQuery = "SELECT  * FROM sanpham WHERE LOAISP = 'douong'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                sanpham douong = new sanpham(100,3,"asdfsadfasdf","asdfsadfsadf","2223020320321","dcdcdcdcdcdcdc");
                douong.setId(cursor.getInt(0));
                douong.setPhobien(cursor.getInt(1));
                douong.setLoaisp(cursor.getString(2));
                douong.setTensp(cursor.getString(3));
                douong.setGia(cursor.getString(4));
                douong.setHinhanh(cursor.getString(5));
                // Adding note to list
                doList.add(douong);
            } while (cursor.moveToNext());
        }

        // return note list
        return doList;
    }
    public List<sanpham> getAlldoan() {
        Log.i(TAG, "database.getAlldoan ... " );

        List<sanpham> daList = new ArrayList<sanpham>();
        // Select All Query
        String selectQuery = "SELECT  * FROM sanpham WHERE LOAISP = 'doan'";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                sanpham da = new sanpham(100,3,"asdfsadfasdf","asdfsadfsadf","2223020320321","dcdcdcdcdcdcdc");
                da.setId(cursor.getInt(0));
                da.setPhobien(cursor.getInt(1));
                da.setLoaisp(cursor.getString(2));
                da.setTensp(cursor.getString(3));
                da.setGia(cursor.getString(4));
                da.setHinhanh(cursor.getString(5));
                // Adding note to list
                daList.add(da);
            } while (cursor.moveToNext());
        }

        // return note list
        return daList;
    }
}
