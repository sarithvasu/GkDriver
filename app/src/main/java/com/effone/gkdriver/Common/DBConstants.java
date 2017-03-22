package com.effone.gkdriver.Common;

/**
 * Created by sarith.vasu on 10-03-2017.
 */

public class DBConstants {
    public final static String DATABASE_NAME = "gkdriver";
    public final static String GK_USER = "gk_user";
    public final static String DRIVER_ID = "driver_id";
    public final static String EMAIL_ID = "email_id";
    public final static String PASSWORD = " password";
    public static final String CREATE_TABLE_LOGIN = "CREATE TABLE  IF NOT EXISTS `" + GK_USER + "` (`" + DRIVER_ID + "` REAL NOT NULL,`" + EMAIL_ID + "` TEXT NOT NULL,`" + PASSWORD + "` TEXT NOT NULL);";
    public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public final static String DRIVER_AVAILABILTY = "driver_availability";
    public final static String AREA_CODE = "area_id";
    public final static String DRIVER_AVAILANILITY_STATUS = "driver_availability_status";
    public static final String CREATE_TABLE_DRIVER_AVAILBILTY = "CREATE TABLE  IF NOT EXISTS `" + DRIVER_AVAILABILTY + "` (`" + DRIVER_ID + "` REAL NOT NULL,`" + AREA_CODE + "` TEXT NOT NULL,`" + DRIVER_AVAILANILITY_STATUS + "` BOOLEAN);";
    public final static String WAREHOUSE = "warehouse";
    public final static String WAREHOUSE_ID = "warehouse_id";
    public final static String LATITUDE = "latitude";
    public final static String LONGITUDE = "longitude";
    public final static String IS_OPERATIONAL = "is_operational";
    public final static String WEEK_DAY = "week_day";
    public final static String WORK_HOUR = "work_hour";
    public static final String CREATE_TABLE_WARE_HOUSE = "CREATE TABLE  IF NOT EXISTS `" + WAREHOUSE + "` (`" + WAREHOUSE_ID + "` REAL NOT NULL,`" + LATITUDE + "` REAL NOT NULL,`" + LONGITUDE + "` REAL NOT NULL,`" + IS_OPERATIONAL + "` TEXT NOT NULL,`" + WEEK_DAY + "` TEXT NOT NULL,`" + WORK_HOUR + "` TEXT);";
    public final static  String DELIVERED="delivered";
    public final static String ORDERHISTORY = "order_history";
    public final static String ORDER_ID = "order_id";
    public final static String CUSTOMER_NAME = "customer_name";
    public final static String ADDRESS = "address";
    public final static String ADDRESS1 = "address1";
    public final static  String SALAD="salad_name";
    public final static String PHONE_NUMBER = "phone_number";
    public final static String STATUS = "status";
    public final static String COMMENTS = "comments";
    public final static String DATE_TIME = "date_time";

    public static final String CREATE_TABLE_ORDER_HISTORY = "CREATE TABLE  IF NOT EXISTS `" + ORDERHISTORY + "` (`" + ORDER_ID + "` REAL NOT NULL,`" + DRIVER_ID + "` REAL NOT NULL,`" + CUSTOMER_NAME + "` TEXT NOT NULL,`" + ADDRESS + "` TEXT NOT NULL,`" + ADDRESS1 + "` TEXT NOT NULL,`" + PHONE_NUMBER + "` TEXT NOT NULL,`" + STATUS + "` TEXT NOT NULL,`" + SALAD + "` TEXT NOT NULL,`" + COMMENTS + "` TEXT ,`" + DATE_TIME + "` TEXT );";


}