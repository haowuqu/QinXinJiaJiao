package com.bug.qinxin.entity;



import javax.persistence.*;
import java.util.Date;


/**
 * 用户反馈的意见存储数据表
 */
@Entity
@Table(name = "evaluate")
public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;

    /**
     * 家长手机号
     */
    @Column(name = "par_phone", length = 11)
    private String parPhone;
    /**
     * 教师手机号
     */
    @Column(name = "tea_phone", length = 11)
    private String teaPhone;
    /**
     * 内容
     */
    private String content;
    /**
     * TODO 提交时间
     */
    private Date date;
    /**
     * 科目
     */
    private String subject;

    @Override
    public String toString() {
        return "Evaluate{" +
                "id=" + id +
                ", parPhone='" + parPhone + '\'' +
                ", teaPhone='" + teaPhone + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", subject='" + subject + '\'' +
                '}';
    }

    public Evaluate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getParPhone() {
        return parPhone;
    }

    public void setParPhone(String parPhone) {
        this.parPhone = parPhone;
    }

    public String getTeaPhone() {
        return teaPhone;
    }

    public void setTeaPhone(String teaPhone) {
        this.teaPhone = teaPhone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
