package com.entity;

import java.util.HashSet;
import java.util.Set;

public class Booktype {
    private int id;
    private String type;
    private Set<Book> bookSet = new HashSet<Book>();

    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Booktype{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
