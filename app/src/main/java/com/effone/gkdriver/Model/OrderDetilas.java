package com.effone.gkdriver.Model;

/**
 * Created by sarith.vasu on 09-03-2017.
 */

public class OrderDetilas {
    private String status;
    private String dateofDelivery;
    private String itemName;
    private String time;
    private String address;
    private String address2;
    private String name;
    private String phone;
    private int order_id;
    private int driver_id;

    public OrderDetilas() {

    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateofDelivery() {
        return dateofDelivery;
    }

    public void setDateofDelivery(String dateofDelivery) {
        this.dateofDelivery = dateofDelivery;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OrderDetilas(int order_id, int driver_id, String status, String dateofDelivery, String time, String itemName, String address, String address2, String name, String phone) {
        this.order_id = order_id;
        this.driver_id = driver_id;
        this.status = status;
        this.dateofDelivery = dateofDelivery;
        this.itemName = itemName;
        this.time = time;
        this.address = address;
        this.address2 = address2;
        this.name = name;
        this.phone = phone;
    }
}
