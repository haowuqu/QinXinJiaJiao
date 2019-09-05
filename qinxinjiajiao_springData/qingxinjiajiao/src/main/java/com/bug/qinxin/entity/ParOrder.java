package com.bug.qinxin.entity;

import javax.persistence.*;

/**
 * 家长订单表
 */
@Entity
@Table(name = "par_order")
public class ParOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;

    /**
     * 手机号
     */
    @Column(name = "par_phone", length = 11)
    private String parPhone;

    /**
     * 所购买书籍的名称
     */
    private String bookname;
    /**
     * 数量
     */
    private String count;
    /**
     * 价格
     */
    private String price;
    /**
     * 是否已经收货
     */
    private String state;

    public ParOrder() {
    }

    public ParOrder(String parPhone, String bookname, String count, String price, String state) {
        this.parPhone = parPhone;
        this.bookname = bookname;
        this.count = count;
        this.price = price;
        this.state = state;
    }

    @Override
    public String toString() {
        return "ParOrder{" +
                "id=" + id +
                ", parPhone='" + parPhone + '\'' +
                ", bookname='" + bookname + '\'' +
                ", count='" + count + '\'' +
                ", price='" + price + '\'' +
                ", state='" + state + '\'' +
                '}';
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

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
