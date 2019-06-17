
package com.action;

import com.entity.Affiche;
import com.entity.Book;
import com.entity.Booktype;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;
import java.util.ArrayList;
import java.util.List;

public class IndexAction extends ActionSupport {
    private List<Book> list = new ArrayList();
    private List<Booktype> booktypelist = new ArrayList();
    private List<Affiche> afficheList = new ArrayList();
    private int booktypeidNow = 1;
    private int typeSize;

    public String index() {
        String[] s1 = new String[0];
        String hql = "from Booktype";
        this.booktypelist = DBO.query(hql, s1);
        System.out.println(this.booktypelist);
        this.setTypeSize(DBO.getCount(hql, s1));
        hql = "from Affiche order by addtime";
        this.afficheList = DBO.queryByPage(hql, s1, 1, 5);
        String[] s2 = new String[]{"0"};
        hql = "from Book where state=? order by addtime";
        this.list = DBO.queryByPage(hql, s2, 1, 5);
        return "success";
    }

    public IndexAction() {
    }

    public List<Book> getList() {
        return this.list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public List<Booktype> getBooktypelist() {
        return this.booktypelist;
    }

    public void setBooktypelist(List<Booktype> booktypelist) {
        this.booktypelist = booktypelist;
    }

    public List<Affiche> getAfficheList() {
        return this.afficheList;
    }

    public void setAfficheList(List<Affiche> afficheList) {
        this.afficheList = afficheList;
    }

    public int getBooktypeidNow() {
        return this.booktypeidNow;
    }

    public void setBooktypeidNow(int booktypeidNow) {
        this.booktypeidNow = booktypeidNow;
    }

    public int getTypeSize() {
        return this.typeSize;
    }

    public void setTypeSize(int typeSize) {
        this.typeSize = typeSize;
    }
}
