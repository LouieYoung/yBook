package com.entity;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Order{
    private int id;
    //private int customerid;//买家的用户id
    private Date date;
    private String place;
    private User user;
    //代表一个order对应多个book
    private Set<Book> bookSet = new HashSet<Book>();

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    /*public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }
*/
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                //", customerid=" + customerid +
                ", date=" + date +
                ", place='" + place + '\'' +
                '}';
    }
}
