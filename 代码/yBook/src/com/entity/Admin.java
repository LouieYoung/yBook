package com.entity;

import java.util.HashSet;
import java.util.Set;

public class Admin {
    private int id;
    private String username;
    private String password;
    private String type;
    private Set<Affiche> afficheSet = new HashSet<Affiche>();

    public Set<Affiche> getAfficheSet() {
        return afficheSet;
    }

    public void setAfficheSet(Set<Affiche> afficheSet) {
        this.afficheSet = afficheSet;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
