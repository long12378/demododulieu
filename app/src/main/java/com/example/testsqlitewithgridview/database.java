package com.example.testsqlitewithgridview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    public void QueryData(String sql){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery(sql,null);
    }
//    private static final String TAG = "SQLite";
//    private static final int DATABASE_VERSION = 1;
//    private static final String DATABASE_NAME = "bancaphe";
//    private static final String TABLE_CAPHE = "Caphe";
//    private static final String COLUMN_CAPHE_ID = "Caphe_Id";
//    private static final String COLUMN_CAPHE_TITLE = "Caphe_Title";
//    private static final String COLUMN_HINHANH = "Caphe_Hinhanh";
//    private static final String COLUMN_GIA = "Caphe_Gia";
//
//    public database(Context context){
//        super(context, DATABASE_NAME, null, DATABASE_VERSION,);
//
//    }



    @Override
    public void onCreate(SQLiteDatabase db) {
//        Log.i(TAG, "database.onCreate ...");
//        String script = "CREATE TABLE " + TABLE_CAPHE +"("
//                + COLUMN_CAPHE_ID +"INTEGER PRIMARY KEY AUTOINCREMENT " + COLUMN_CAPHE_TITLE + "TEXT, "
//                + COLUMN_GIA + "DECIMAL, "
//                + COLUMN_HINHANH +"TEXT" + ")";
//        db.execSQL(script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        Log.i(TAG, "database.onUpgrade ... ");
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAPHE);
//        onCreate(db);
    }
//    public void createDefaultCapheIfNeed(){
//        int count = this getCapheCount();
//        if(count == 0){
//            caphe caphe1 = new caphe("Cappuchino", 3000000,"phobien1");
//            caphe caphe2 = new caphe("Ca phe da", 3000000,"phobien2");
//
//        }
//
//    }
//    public void AddCaphe(caphe caphe){
//        Log.i(TAG, "database.AddCaphe ... " + caphe.getTensp());
//        SQLiteDatabase db =this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_CAPHE_TITLE ,caphe.getTensp());
//        values.put(COLUMN_GIA, caphe.getGia());
//        values.put(COLUMN_HINHANH, caphe.getHinhanh());
//        db.insert(TABLE_CAPHE, null, values);
//        db.close();
//    }
//    public int getCapheCount(){
//        Log.i(TAG ,"database.getCapheCount ... " );
//        String countQuery = "SELECT * FROM " + TABLE_CAPHE;
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery(countQuery,null);
//        int count = cursor.getCount();
//        cursor.close();
//        return count;
//    }
}
