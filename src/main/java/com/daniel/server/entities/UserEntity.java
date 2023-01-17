package com.daniel.server.entities;

import com.daniel.server.enums.UserType;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name" , nullable = false , unique = true)
    private String userName;

    @Column(name = "password" , nullable = false)
    private String password;

    @Column(name = "user_type" , nullable = false)
    private UserType userType;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;
    @Column(name = "time_stamp" , nullable = false)
    private Date timeStamp;

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public UserEntity() {
    }

    public UserEntity(long id, String userName, String password, UserType userType, Date timeStamp) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.timeStamp = timeStamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
