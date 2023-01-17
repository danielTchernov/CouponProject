package com.daniel.server.beans;

import java.sql.Date;

public class Coupons {
    private long id;
    private String name;
    private String phoneNumber;
    private String address;
    private long categoryID;
    private Date start_date;
    private Date end_date;
    private String description;
    private float price;
    private long companyId;
    public Coupons(long id, String name, String phoneNumber, String address, long categoryID, Date start_date, Date end_date, String description, float price , int companyId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.categoryID = categoryID;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.price = price;
        this.companyId = companyId;
    }

    public Coupons(String name, String phoneNumber, String address, long categoryID, Date start_date, Date end_date, String description, float price, long companyId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.categoryID = categoryID;
        this.start_date = start_date;
        this.end_date = end_date;
        this.description = description;
        this.price = price;
        this.companyId = companyId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "CouponEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", categoryID=" + categoryID +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", companyId=" + companyId +
                '}';
    }
}
