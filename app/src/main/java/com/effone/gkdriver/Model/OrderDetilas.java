package com.effone.gkdriver.Model;

/**
 * Created by sarith.vasu on 09-03-2017.
 */

public class OrderDetilas {
    private String DateofDelivery;
    private String ItemName;
    private String Time;
    private String Address;
    private String Address2;
    private String Name;

    public OrderDetilas(String dateofDelivery, String time, String itemName, String address, String address2, String name, String phone) {
        DateofDelivery = dateofDelivery;
        ItemName = itemName;
        Time = time;
        Address = address;
        Address2 = address2;
        Name = name;
        Phone = phone;
    }

    private String Phone;

    public String getDateofDelivery() {
        return DateofDelivery;
    }

    public void setDateofDelivery(String dateofDelivery) {
        DateofDelivery = dateofDelivery;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getAddress2() {
        return Address2;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


}
