package com.bug.qinxin.entity;

import javax.persistence.*;

/**
 * 个人信息界面学习计划对应的表
 */
@Entity
@Table(name = "plant")
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;
    /**
     * 家长手机号
     */
    @Column(name = "plant_phonenum", length = 11)
    private String plantPhoneNum;
    /**
     * 计划学习的内容
     */
    @Column(name = "plant_con")
    private String plantCon;
    /**
     * TODO 计划完成的时间信息
     */
    private String datetime;

    public Plant() {
    }

    public Plant(String plantPhoneNum, String plantCon, String datetime) {
        this.plantPhoneNum = plantPhoneNum;
        this.plantCon = plantCon;
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "id=" + id +
                ", plantPhoneNum='" + plantPhoneNum + '\'' +
                ", plantCon='" + plantCon + '\'' +
                ", datetime=" + datetime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlantPhoneNum() {
        return plantPhoneNum;
    }

    public void setPlantPhoneNum(String plantPhoneNum) {
        this.plantPhoneNum = plantPhoneNum;
    }

    public String getPlantCon() {
        return plantCon;
    }

    public void setPlantCon(String plantCon) {
        this.plantCon = plantCon;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
