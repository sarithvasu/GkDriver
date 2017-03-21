package com.effone.gkdriver.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import static com.effone.gkdriver.Common.DBConstants.CREATE_TABLE_LOGIN;
import static com.effone.gkdriver.Common.DBConstants.DATE_FORMAT;
import static com.effone.gkdriver.Common.DBConstants.DRIVER_ID;
import static com.effone.gkdriver.Common.DBConstants.EMAIL_ID;
import static com.effone.gkdriver.Common.DBConstants.GK_USER;
import static com.effone.gkdriver.Common.DBConstants.PASSWORD;

/**
 * Created by sarith.vasu on 10-03-2017.
 */

public class InsertDbHelper extends DataBaseHelper {


    Context context;

    public InsertDbHelper(Context context) {
        super(context);
        this.context = context;
    }

    public boolean login_user(String driver_id,String email,String password){



        long i = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DRIVER_ID, driver_id);
            contentValues.put(EMAIL_ID, email);
            contentValues.put(PASSWORD, password);
            i = db.insert(GK_USER, null, contentValues);

        }
        if(i!=0)
            return true;
        else
            return false;
    }

    public boolean update_login_user() {
        SQLiteDatabase db = this.getWritableDatabase();
        if (db != null) {
            long i = db.delete(GK_USER, null,null);
            if (i != 0) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
