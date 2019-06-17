//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.action;

import com.entity.Book;
import com.entity.Booktype;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;
import java.util.ArrayList;
import java.util.List;

public class BookTypeAction extends ActionSupport {
    private List<Book> list = new ArrayList();
    private List<Booktype> booktypelist = new ArrayList();
    private int booktypeidNow = 1;
    private int typeSize;
    private int pageNow = 1;
    private int maxSize;
    private int pageSize = 10;
    private int maxPage;

    public BookTypeAction() {
    }

    public int getTypeSize() {
        return this.typeSize;
    }

    public void setTypeSize(int typeSize) {
        this.typeSize = typeSize;
    }

    public int getBooktypeidNow() {
        return this.booktypeidNow;
    }

    public void setBooktypeidNow(int booktypeidNow) {
        this.booktypeidNow = booktypeidNow;
    }

    public List<Booktype> getBooktypelist() {
        return this.booktypelist;
    }

    public void setBooktypelist(List<Booktype> booktypelist) {
        this.booktypelist = booktypelist;
    }

    public List<Book> getList() {
        return this.list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMaxPage() {
        return this.maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageNow() {
        return this.pageNow;
    }

    public String booktype() {
        String[] s1 = new String[0];
        String hql = "from Booktype";
        this.booktypelist = DBO.query(hql, s1);
        this.setTypeSize(DBO.getCount(hql, s1));
        String[] s2 = new String[]{"0", String.valueOf(this.booktypeidNow)};
        hql = "from Book where state=? and booktype.id=?";
        this.setMaxSize(DBO.getCount(hql, s2));
        System.out.println(this.getMaxSize());
        int a = 0;
        if (this.maxSize % this.pageSize > 0) {
            a = 1;
        }

        this.setMaxPage(this.maxSize / this.pageSize + a);
        if (this.pageNow == this.maxPage + 1) {
            this.setPageNow(this.pageNow - 1);
            this.list = DBO.queryByPage(hql, s2, this.pageNow, this.pageSize);
            return "success";
        } else if (this.pageNow == 0) {
            this.setPageNow(this.pageNow + 1);
            this.list = DBO.queryByPage(hql, s2, this.pageNow, this.pageSize);
            return "success";
        } else if (this.pageNow > 0 && this.pageNow <= this.maxPage) {
            this.list = DBO.queryByPage(hql, s2, this.pageNow, this.pageSize);
            return "success";
        } else {
            return "success";
        }
    }
}
