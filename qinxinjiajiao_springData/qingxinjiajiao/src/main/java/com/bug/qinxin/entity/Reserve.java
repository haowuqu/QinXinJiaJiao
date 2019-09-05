package com.bug.qinxin.entity;

import javax.persistence.*;

/**
 * 对应家长预约的教师信息表
 */
@Entity
@Table(name = "reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;
    /**
     * 家长的手机号
     */
    @Column(name = "paret_phone")
    private String paretPhone;
    /**
     * 教师的手机号
     */
    @Column(name = "teach_phone")
    private String teachPhone;
    /**
     * 教师的名字
     */
    @Column(name = "teach_name")
    private String teachName;

    /**
     * 预约的科目
     */
    private String subject;
    /**
     * TODO 预约的时间
     */
    private String data;

    public Reserve() {
    }

    public Reserve(String parPhone, String teachPhone, String teachName, String subject, String date) {
        this.paretPhone = parPhone;
        this.teachPhone = teachPhone;
        this.teachName = teachName;
        this.subject = subject;
        this.data =date;
    }

    @Override
    public String toString() {
        return "Reserve{" +
                "id=" + id +
                ", paretPhone='" + paretPhone + '\'' +
                ", teachPhone='" + teachPhone + '\'' +
                ", teachName='" + teachName + '\'' +
                ", subject='" + subject + '\'' +
                ", data=" + data +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParetPhone() {
        return paretPhone;
    }

    public void setParetPhone(String paretPhone) {
        this.paretPhone = paretPhone;
    }

    public String getTeachPhone() {
        return teachPhone;
    }

    public void setTeachPhone(String teachPhone) {
        this.teachPhone = teachPhone;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
