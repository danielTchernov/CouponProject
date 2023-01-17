package com.daniel.server.beans;

import java.sql.Date;

public class Purchase {
    private long id;
    private long userId;
    private String couponName;
    private int couponId;
    private int amount;
    private Date timeStamp;

    public Purchase(long userId, String couponName, int couponId, int amount, Date timeStamp) {
        this.userId = userId;
        this.couponName = couponName;
        this.couponId = couponId;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public Purchase(long id, long userId, String couponName, int couponId, int amount, Date timeStamp) {
        this.id = id;
        this.userId = userId;
        this.couponName = couponName;
        this.couponId = couponId;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }


    @Override
    public String toString() {
        return "PurchaseEntity{" +
                "userId=" + userId +
                ", couponName='" + couponName + '\'' +
                ", couponId=" + couponId +
                ", amount=" + amount +
                ", timeStamp=" + timeStamp +
                '}';
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
