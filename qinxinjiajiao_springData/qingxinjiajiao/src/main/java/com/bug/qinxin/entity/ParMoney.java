package com.bug.qinxin.entity;

import javax.persistence.*;

/**
 * 家长钱包信息存储表
 */
@Entity
@Table(name = "par_money")
public class ParMoney {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;
    /**
     * 手机号
     */
    @Column(length = 11)
    private String phonenum;
    /**
     * 账户的钱
     */
    @Column(name = "par_balance")
    private String parBalance;

    /**
     * 余额
     */
    @Column(length = 11)
    private String yue;
    /**
     * 积分信息
     */
    @Column(length = 11)
    private String jifen;

    public ParMoney() {
    }

    public ParMoney(String phonenum, String parBalance, String yue, String jifen) {
        this.phonenum = phonenum;
        this.parBalance = parBalance;
        this.yue = yue;
        this.jifen = jifen;
    }

    @Override
    public String toString() {
        return "ParMoney{" +
                "id=" + id +
                ", phonenum='" + phonenum + '\'' +
                ", parBalance='" + parBalance + '\'' +
                ", yue='" + yue + '\'' +
                ", jifen='" + jifen + '\'' +
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

    public String getParBalance() {
        return parBalance;
    }

    public void setParBalance(String parBalance) {
        this.parBalance = parBalance;
    }

    public String getYue() {
        return yue;
    }

    public void setYue(String yue) {
        this.yue = yue;
    }

    public String getJifen() {
        return jifen;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen;
    }
}
