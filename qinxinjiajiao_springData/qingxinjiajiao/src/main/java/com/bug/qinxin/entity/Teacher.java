package com.bug.qinxin.entity;

import javax.persistence.*;

/**
 * 教师信息表
 */
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;
    /**
     * 手机号
     */
    @Column(name = "teache_phonum")
    private String teachePhonum;
    /**
     * 性别
     */
    @Column(name = "teach_sex")
    private String teachSex;
    /**
     * 名字
     */
    @Column(name = "teach_name")
    private String teachName;
    /**
     * 头像
     */
    @Column(name = "teach_icon")
    private String teachIcon;
    /**
     * 地址
     */
    @Column(name = "teach_address")
    private String teachAddress;
    /**
     * 教学经历
     */
    @Column(name = "teach_exper")
    private String teachExper;
    /**
     *
     */
    @Column(name = "teach_sub")
    private String teachSub;
    /**
     * 所教年级
     */
    private String grade;

    public Teacher() {
    }

    public Teacher(String teachePhonum, String teachSex, String teachName, String teachIcon, String teachAddress, String teachExper, String teachSub, String grade) {
        this.teachePhonum = teachePhonum;
        this.teachSex = teachSex;
        this.teachName = teachName;
        this.teachIcon = teachIcon;
        this.teachAddress = teachAddress;
        this.teachExper = teachExper;
        this.teachSub = teachSub;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teachePhonum='" + teachePhonum + '\'' +
                ", teachSex='" + teachSex + '\'' +
                ", teachName='" + teachName + '\'' +
                ", teachIcon='" + teachIcon + '\'' +
                ", teachAddress='" + teachAddress + '\'' +
                ", teachExper='" + teachExper + '\'' +
                ", teachSub='" + teachSub + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeachePhonum() {
        return teachePhonum;
    }

    public void setTeachePhonum(String teachePhonum) {
        this.teachePhonum = teachePhonum;
    }

    public String getTeachSex() {
        return teachSex;
    }

    public void setTeachSex(String teachSex) {
        this.teachSex = teachSex;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getTeachIcon() {
        return teachIcon;
    }

    public void setTeachIcon(String teachIcon) {
        this.teachIcon = teachIcon;
    }

    public String getTeachAddress() {
        return teachAddress;
    }

    public void setTeachAddress(String teachAddress) {
        this.teachAddress = teachAddress;
    }

    public String getTeachExper() {
        return teachExper;
    }

    public void setTeachExper(String teachExper) {
        this.teachExper = teachExper;
    }

    public String getTeachSub() {
        return teachSub;
    }

    public void setTeachSub(String teachSub) {
        this.teachSub = teachSub;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
