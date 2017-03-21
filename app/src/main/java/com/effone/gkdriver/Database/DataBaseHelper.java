package com.effone.gkdriver.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import static com.effone.gkdriver.Common.DBConstants.CREATE_TABLE_DRIVER_AVAILBILTY;
import static com.effone.gkdriver.Common.DBConstants.CREATE_TABLE_LOGIN;
import static com.effone.gkdriver.Common.DBConstants.CREATE_TABLE_ORDER_HISTORY;
import static com.effone.gkdriver.Common.DBConstants.CREATE_TABLE_WARE_HOUSE;
import static com.effone.gkdriver.Common.DBConstants.DATABASE_NAME;

/**
 * Created by sarith.vasu on 10-03-2017.
 */


public class DataBaseHelper extends SQLiteOpenHelper {
    private Context mContext;

    private static int DB_VERSION = 1;
    private static String DB_PATH = "";

    public DataBaseHelper(Context context){

        super(context, DATABASE_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_LOGIN);
        sqLiteDatabase.execSQL(CREATE_TABLE_DRIVER_AVAILBILTY);
        sqLiteDatabase.execSQL(CREATE_TABLE_ORDER_HISTORY);
        sqLiteDatabase.execSQL(CREATE_TABLE_WARE_HOUSE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public SQLiteDatabase OpenDataBase() {
        SQLiteDatabase db = null;

        try {
            String myPath = DB_PATH + DATABASE_NAME;

            db = SQLiteDatabase.openOrCreateDatabase(myPath, null, null);
            db.execSQL("PRAGMA foreign_keys = ON;");




        } catch (SQLiteException e) {
            db = null;
            e.printStackTrace();
        }

        return db;
    }
}
