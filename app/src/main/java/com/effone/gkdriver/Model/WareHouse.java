package com.effone.gkdriver.Model;

/**
 * Created by sarith.vasu on 21-03-2017.
 */

public class WareHouse {
    private int warehouse_id;
    private String latitude;
    private String longitude;
    private String is_operational;
    private String week_day;
    private String work_hour;


    public int getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(int warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getIs_operational() {
        return is_operational;
    }

    public void setIs_operational(String is_operational) {
        this.is_operational = is_operational;
    }

    public String getWeek_day() {
        return week_day;
    }

    public void setWeek_day(String week_day) {
        this.week_day = week_day;
    }

    public String getWork_hour() {
        return work_hour;
    }

    public void setWork_hour(String work_hour) {
        this.work_hour = work_hour;
    }
}
