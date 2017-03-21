package com.effone.gkdriver.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.effone.gkdriver.Model.OrderDetilas;
import com.effone.gkdriver.Model.OrderHistory;
import com.effone.gkdriver.Model.WareHouse;

import java.util.ArrayList;

import static com.effone.gkdriver.Common.DBConstants.ADDRESS;
import static com.effone.gkdriver.Common.DBConstants.COMMENTS;
import static com.effone.gkdriver.Common.DBConstants.CREATE_TABLE_LOGIN;
import static com.effone.gkdriver.Common.DBConstants.CUSTOMER_NAME;
import static com.effone.gkdriver.Common.DBConstants.DRIVER_ID;
import static com.effone.gkdriver.Common.DBConstants.GK_USER;
import static com.effone.gkdriver.Common.DBConstants.IS_OPERATIONAL;
import static com.effone.gkdriver.Common.DBConstants.LATITUDE;
import static com.effone.gkdriver.Common.DBConstants.LONGITUDE;
import static com.effone.gkdriver.Common.DBConstants.ORDERHISTORY;
import static com.effone.gkdriver.Common.DBConstants.ORDER_ID;
import static com.effone.gkdriver.Common.DBConstants.PHONE_NUMBER;
import static com.effone.gkdriver.Common.DBConstants.STATUS;
import static com.effone.gkdriver.Common.DBConstants.WAREHOUSE;
import static com.effone.gkdriver.Common.DBConstants.WAREHOUSE_ID;
import static com.effone.gkdriver.Common.DBConstants.WEEK_DAY;
import static com.effone.gkdriver.Common.DBConstants.WORK_HOUR;

/**
 * Created by sarith.vasu on 10-03-2017.
 */

public class SelectDbHelper extends DataBaseHelper {
    Context context;
    public SelectDbHelper(Context context) {
        super(context);
        this.context=context;
    }
    public long countNumberOfRecords(){
        SQLiteDatabase db=this.getWritableDatabase();
        String name = null;
        long numberOfRows = DatabaseUtils.queryNumEntries(db, GK_USER);
        return numberOfRows;
    }


    public ArrayList<OrderHistory> orderList(){
        ArrayList<OrderHistory> orderHistories = new ArrayList<OrderHistory>();
        Cursor cursor = null;
        SQLiteDatabase db = this.OpenDataBase();
        if (db != null) {
            String query="select * from " +ORDERHISTORY;
            cursor = db.rawQuery(query, null);
            if (cursor != null) {
                if (cursor.getCount() >= 1) {
                    if (cursor.moveToFirst()) {
                        do {
                            OrderHistory orderHistory = new OrderHistory();
                            orderHistory.setOrder_id(cursor.getInt(cursor.getColumnIndex(ORDER_ID)));
                            orderHistory.setDriver_id(cursor.getString(cursor.getColumnIndex(DRIVER_ID)));
                            orderHistory.setCustomer_name(cursor.getString(cursor.getColumnIndex(CUSTOMER_NAME)));
                            orderHistory.setAddress(cursor.getString(cursor.getColumnIndex(ADDRESS)));
                            orderHistory.setPhone_number(cursor.getString(cursor.getColumnIndex(PHONE_NUMBER)));
                            orderHistory.setStatus(cursor.getString(cursor.getColumnIndex(STATUS)));
                            orderHistory.setComments(cursor.getString(cursor.getColumnIndex(COMMENTS)));
                            orderHistories.add(orderHistory);
                        } while (cursor.moveToNext());
                    }

                }
            }
        }

        return orderHistories;
    }



    public ArrayList<WareHouse> deliveryAreas(){
        ArrayList<WareHouse> wareHouses = new ArrayList<WareHouse>();
        Cursor cursor = null;
        SQLiteDatabase db = this.OpenDataBase();
        if (db != null) {
            String query="select * from " +WAREHOUSE;
            cursor = db.rawQuery(query, null);
            if (cursor != null) {
                if (cursor.getCount() >= 1) {
                    if (cursor.moveToFirst()) {
                        do {
                            WareHouse orderHistory = new WareHouse();
                            orderHistory.setWarehouse_id(cursor.getInt(cursor.getColumnIndex(WAREHOUSE_ID)));
                            orderHistory.setLatitude(cursor.getString(cursor.getColumnIndex(LATITUDE)));
                            orderHistory.setLongitude(cursor.getString(cursor.getColumnIndex(LONGITUDE)));
                            orderHistory.setIs_operational(cursor.getString(cursor.getColumnIndex(IS_OPERATIONAL)));
                            orderHistory.setWeek_day(cursor.getString(cursor.getColumnIndex(WEEK_DAY)));
                            orderHistory.setWork_hour(cursor.getString(cursor.getColumnIndex(WORK_HOUR)));
                            wareHouses.add(orderHistory);
                        } while (cursor.moveToNext());
                    }

                }
            }
        }

        return wareHouses;
    }

}
