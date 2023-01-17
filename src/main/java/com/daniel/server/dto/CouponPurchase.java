package com.daniel.server.dto;

import java.sql.Date;

public class CouponPurchase {
    private long userId;
    private String couponName;
    private long couponId;
    private int amount;
    private Date timeStamp;
    private Date startDate;
    private Date endDate;
    private double price;
    private String companyName;

    public CouponPurchase(long userId, String couponName, long couponId, int amount, Date timeStamp, Date startDate, Date endDate, double price, String companyName) {
        this.userId = userId;
        this.couponName = couponName;
        this.couponId = couponId;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.companyName = companyName;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "CouponPurchase{" +
                "userId=" + userId +
                ", couponName='" + couponName + '\'' +
                ", couponId=" + couponId +
                ", amount=" + amount +
                ", timeStamp=" + timeStamp +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
