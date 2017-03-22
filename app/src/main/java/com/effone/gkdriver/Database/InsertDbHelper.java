package com.effone.gkdriver.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.effone.gkdriver.Model.OrderDetilas;
import com.effone.gkdriver.Model.OrderHistory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static com.effone.gkdriver.Common.DBConstants.ADDRESS;
import static com.effone.gkdriver.Common.DBConstants.ADDRESS1;
import static com.effone.gkdriver.Common.DBConstants.COMMENTS;
import static com.effone.gkdriver.Common.DBConstants.CREATE_TABLE_LOGIN;
import static com.effone.gkdriver.Common.DBConstants.CUSTOMER_NAME;
import static com.effone.gkdriver.Common.DBConstants.DATE_FORMAT;
import static com.effone.gkdriver.Common.DBConstants.DATE_TIME;
import static com.effone.gkdriver.Common.DBConstants.DRIVER_ID;
import static com.effone.gkdriver.Common.DBConstants.EMAIL_ID;
import static com.effone.gkdriver.Common.DBConstants.GK_USER;
import static com.effone.gkdriver.Common.DBConstants.ORDERHISTORY;
import static com.effone.gkdriver.Common.DBConstants.ORDER_ID;
import static com.effone.gkdriver.Common.DBConstants.PASSWORD;
import static com.effone.gkdriver.Common.DBConstants.PHONE_NUMBER;
import static com.effone.gkdriver.Common.DBConstants.SALAD;
import static com.effone.gkdriver.Common.DBConstants.STATUS;

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

    public void insertIntoOrderHistory(ArrayList<OrderDetilas> OrderDetilas) {



        SQLiteDatabase db = this.getWritableDatabase();
        for (OrderDetilas history : OrderDetilas) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(STATUS, history.getStatus());
            contentValues.put(ORDER_ID, history.getOrder_id());
            contentValues.put(DRIVER_ID, history.getDriver_id());
            contentValues.put(CUSTOMER_NAME, history.getName());
            contentValues.put(ADDRESS, history.getAddress());
            contentValues.put(ADDRESS1,history.getAddress2());
            contentValues.put(PHONE_NUMBER, history.getPhone());
            contentValues.put(SALAD, history.getItemName());
            contentValues.put(COMMENTS, "");
            contentValues.put(DATE_TIME, "");

            db.insert(ORDERHISTORY, null, contentValues);

        }
    }


}
