package com.daniel.server.beans;
import com.daniel.server.enums.UserType;

import java.sql.Date;

public class User {
    private long id;
    private String userName;
    private String password;
    private UserType userType;
    private Integer companyId;
    private Date timeStamp;

    public User(long id, String userName, String password, UserType userType, Integer companyId, Date timeStamp) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.companyId = companyId;
        this.timeStamp = timeStamp;
    }

    public User(String userName, String password, UserType userType, Integer companyId , Date timeStamp) {
        this.userName = userName;
        this.password = password;
        this.userType = userType;
        this.companyId = companyId;
        this.timeStamp = timeStamp;
    }

    public User() {
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", companyId=" + companyId +
                ", timeStamp=" + timeStamp +
                '}';
    }
}
