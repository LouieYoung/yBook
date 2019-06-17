package com.entity;

import java.util.HashSet;
import java.util.Set;

public class Major {
    private int id;
    private String major;
    private Set<User> userSet = new HashSet<User>();

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", major='" + major + '\'' +
                '}';
    }
}
