package com.bug.qinxin.entity;

import javax.persistence.*;

/**
 * 拥有的奖学券信息表
 */
@Entity
@Table(name = "par_reward")
public class ParReward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;

    /**
     * 家长手机号
     */
    @Column(length = 11)
    private String phonenum;

    /**
     * 奖学卷面额
     */
    private String acount;

    /**
     * TODO 数量信息
     */
    private String data;


    public ParReward() {
    }

    public ParReward(String phonenum, String acount, String data) {
        this.phonenum = phonenum;
        this.acount = acount;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ParReward{" +
                "id=" + id +
                ", phonenum='" + phonenum + '\'' +
                ", acount='" + acount + '\'' +
                ", data='" + data + '\'' +
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

    public String getAcount() {
        return acount;
    }

    public void setAcount(String acount) {
        this.acount = acount;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
