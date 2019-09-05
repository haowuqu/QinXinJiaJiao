package com.bug.qinxin.entity;

import javax.persistence.*;

/**
 * 存储家长用户表（本应用面对的是家教家长客户端）
 */
@Entity
@Table(name = "parent")
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;
    /**
     * 手机号
     */
    private String phonenum;
    /**
     * 密码
     */
    private String paswd;
    /**
     * 头像
     */
    private String icon;
    /**
     * 地址
     */
    private String address;

    public Parent(String phone, String password) {
        this.phonenum = phone;
        this.paswd = password;
    }

    public Parent() {
    }

    @Override
    public String toString() {
        return "Parent{" +
                "id=" + id +
                ", phonenum='" + phonenum + '\'' +
                ", paswd='" + paswd + '\'' +
                ", icon='" + icon + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }

    public String getPaswd() {
        return paswd;
    }

    public void setPaswd(String paswd) {
        this.paswd = paswd;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
