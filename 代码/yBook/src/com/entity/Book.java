package com.entity;

import java.sql.Date;

public class Book {
    private int id;
    private int uid;//user上传的id
    private int cid;//买家id
    private Booktype booktype;

    public Booktype getBooktype() {
        return booktype;
    }

    public void setBooktype(Booktype booktype) {
        this.booktype = booktype;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    private int state;//0为还没卖掉，1为卖掉了
    private double price;
    private Date adddate;
    private String bookname;
    //private String booktypeid;//对应图书类型id
    private String pic;
    private String introduction;
    private Order order;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

   /* public String getBooktypeid() {
        return booktypeid;
    }

    public void setBooktypeid(String booktypeid) {
        this.booktypeid = booktypeid;
    }*/

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", state=" + state +
                ", price=" + price +
                ", adddate=" + adddate +
                ", bookname='" + bookname + '\'' +
                //", booktypeid='" + booktypeid + '\'' +
                ", pic='" + pic + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
