package com.script.scriptreservation.po;

import javax.persistence.*;

@Table(name = "user")
public class User {
    /**
     * 主键ID
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户头像地址
     */
    @Column(name = "photo_adress")
    private String photoAdress;

    /**
     * 用户邮箱验证状态
     */
    private Integer status;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户电话
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 账户余额
     */
    private Integer money;

    /**
     * 获取主键ID
     *
     * @return id - 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键ID
     *
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取用户头像地址
     *
     * @return photo_adress - 用户头像地址
     */
    public String getPhotoAdress() {
        return photoAdress;
    }

    /**
     * 设置用户头像地址
     *
     * @param photoAdress 用户头像地址
     */
    public void setPhotoAdress(String photoAdress) {
        this.photoAdress = photoAdress == null ? null : photoAdress.trim();
    }

    /**
     * 获取用户邮箱验证状态
     *
     * @return status - 用户邮箱验证状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户邮箱验证状态
     *
     * @param status 用户邮箱验证状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取用户邮箱
     *
     * @return email - 用户邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置用户邮箱
     *
     * @param email 用户邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取用户电话
     *
     * @return phone_number - 用户电话
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置用户电话
     *
     * @param phoneNumber 用户电话
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * 获取账户余额
     *
     * @return money - 账户余额
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置账户余额
     *
     * @param money 账户余额
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", photoAdress='" + photoAdress + '\'' +
                ", status=" + status +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", money=" + money +
                '}';
    }
}