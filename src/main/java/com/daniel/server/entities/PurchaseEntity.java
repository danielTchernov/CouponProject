package com.daniel.server.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {

    @Id
    @GeneratedValue
    private long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "coupon_name")
    private CouponEntity couponName;

    @OneToOne
    @JoinColumn(name = "coupon_id")
    private CouponEntity couponId;

    @Column(name = "amount" , nullable = false)
    private int amount;

    @Column(name = "date" , nullable = false)
    private Date timeStamp;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public CouponEntity getCouponName() {
        return couponName;
    }

    public void setCouponName(CouponEntity couponName) {
        this.couponName = couponName;
    }

    public CouponEntity getCouponId() {
        return couponId;
    }

    public void setCouponId(CouponEntity couponId) {
        this.couponId = couponId;
    }

    public PurchaseEntity() {
    }

    public PurchaseEntity(long id, int amount, Date timeStamp) {
        this.id = id;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "PurchaseEntity{" +
                "id=" + id +
                ", amount=" + amount +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
