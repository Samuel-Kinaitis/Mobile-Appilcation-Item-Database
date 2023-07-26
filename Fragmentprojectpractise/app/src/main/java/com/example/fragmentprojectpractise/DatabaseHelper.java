package com.example.fragmentprojectpractise;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by RafihM on 12/27/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private SQLiteDatabase dataBase;
    public static final String DATABASE_NAME = "Inventory.db";
    public static final String TABLE_NAME = "Products";
    //Data base colems
    public static final String COL_1 = "PRODUCT_ID";
    public static final String COL_2 = "PRODUCT_NAME";
    public static final String COL_3 = "PRODUCT_EXPIRATION";
    public static final String COL_4 = "PRODUCT_MANUFACTURER";

    public static final String COL_5 = "PRODUCT_QUANTITY";
    public static final String COL_6 = "PRODUCT_PRICE";
    public static final String COL_7 = "PRODUCT_COST";
    public static final String COL_8 = "PRODUCT_DESCRIPTION";


    //############################


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //  SQLiteDatabase db = this.getReadableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //   db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, FIRSTNAME TEXT, LASTNAME TEXT, GRADE TEXT)");
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUCT_ID TEXT, PRODUCT_NAME TEXT, PRODUCT_EXPIRATION TEXT, PRODUCT_MANUFACTURER TEXT, PRODUCT_QUANTITY TEXT, PRODUCT_PRICE TEXT, PRODUCT_COST TEXT, PRODUCT_DESCRIPTION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_EXPIRATION, String PRODUCT_MANUFACTURER, String PRODUCT_QUANTITY, String PRODUCT_PRICE, String PRODUCT_COST, String PRODUCT_DESCRIPTION){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1,PRODUCT_ID);
        contentValues.put(COL_2,PRODUCT_NAME);
        contentValues.put(COL_3,PRODUCT_EXPIRATION);
        contentValues.put(COL_4,PRODUCT_MANUFACTURER);
        contentValues.put(COL_5,PRODUCT_QUANTITY);
        contentValues.put(COL_6,PRODUCT_PRICE);
        contentValues.put(COL_7,PRODUCT_COST);
        contentValues.put(COL_8,PRODUCT_DESCRIPTION);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result == 1){
            return true;
        }
        else{
            return false;
        }
    }
    public Cursor detAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME,null);
        return res;
    }

    public boolean updateData(String PRODUCT_ID, String PRODUCT_NAME, String PRODUCT_EXPIRATION, String PRODUCT_MANUFACTURER, String PRODUCT_QUANTITY, String PRODUCT_PRICE, String PRODUCT_COST, String PRODUCT_DESCRIPTION){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        // contentValues.put(COL_1,PRODUCT_ID);
        contentValues.put(COL_2,PRODUCT_NAME);
        contentValues.put(COL_3,PRODUCT_EXPIRATION);
        contentValues.put(COL_4,PRODUCT_MANUFACTURER);
        contentValues.put(COL_5,PRODUCT_QUANTITY);
        contentValues.put(COL_6,PRODUCT_PRICE);
        contentValues.put(COL_7,PRODUCT_COST);
        contentValues.put(COL_8,PRODUCT_DESCRIPTION);

        db.update(TABLE_NAME,contentValues, "PRODUCT_ID = ?",new String[]{PRODUCT_ID});
        return true;
    }
    public int deleteData(String rowId)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"PRODUCT_ID = ?",new String[]{rowId});
    }
}
