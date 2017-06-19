package com.example.myself.stuttersupport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Myself on 6/16/2017.
 *
 * Based off DbHelper.java from Learning Android by Marko Gargenta
 */

public class TrackerDbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "tracker.db";
    private static final int DB_VERSION = 1;
    public static final String TABLE = "tracker";
    public static final String C_DATE = "date";
    Context context;

    public TrackerDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    /**
     * Called when DB is first created
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table " + TABLE + " (" + C_DATE + " date primary key)";
        db.execSQL(sql);
        Log.d("TrackerDbHelper", "onCreate w sql: " + sql);
    }

    /**
     * Called whenever the database receives an update
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Temporary and probably bad
        db.execSQL("drop table if exists " + TABLE);
        onCreate(db);
    }
}
