package com.example.paulg.comautis.mvp.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.paulg.comautis.mvp.Database.Table.ChildTable;
import com.example.paulg.comautis.mvp.Database.Table.FolderTable;
import com.example.paulg.comautis.mvp.Database.Table.PageTable;
import com.example.paulg.comautis.mvp.Database.Table.PictureTable;


public class SQLDataBase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "ComAutisDataBase";
    static final int VERSION = 3;


    public SQLDataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(FolderTable.CREATE_TABLE);
        db.execSQL(PictureTable.CREATE_TABLE);
        db.execSQL(ChildTable.CREATE_TABLE);
        db.execSQL(PageTable.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion > newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + PictureTable.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + PageTable.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + ChildTable.TABLE_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + FolderTable.TABLE_NAME);
            onCreate(db);
        }
    }

    public int getVERSION() {
        return VERSION;
    }
}