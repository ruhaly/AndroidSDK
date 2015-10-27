package com.ruhaly.androidsdk.bean;

import java.io.Serializable;

public class UserBean implements Serializable {

    private String userId;
    private String status;
    private String userName;

    private int usernameStatus;
    private String areaCode;
    private String headPic;

    private int isPayed;
    private String payedNum;
    private int payedPeriod;
    private String sex;

    private String birthday, dmcode, areaName, phone, address;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUsernameStatus() {
        return usernameStatus;
    }

    public void setUsernameStatus(int usernameStatus) {
        this.usernameStatus = usernameStatus;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public int getIsPayed() {
        return isPayed;
    }

    public void setIsPayed(int isPayed) {
        this.isPayed = isPayed;
    }

    public String getPayedNum() {
        return payedNum;
    }

    public void setPayedNum(String payedNum) {
        this.payedNum = payedNum;
    }

    public int getPayedPeriod() {
        return payedPeriod;
    }

    public void setPayedPeriod(int payedPeriod) {
        this.payedPeriod = payedPeriod;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDmcode() {
        return dmcode;
    }

    public void setDmcode(String dmcode) {
        this.dmcode = dmcode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
