package com.action;

import com.entity.Book;
import com.util.DBO;

import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class QuickQueryAction {
    private List<Book> list = new ArrayList();
    private List<Book> booklist = new ArrayList();


    public String quickquery() {
        int[] s1 = new int[]{0};
        String hql1 = "from Book where state=?";
        this.booklist = DBO.query(hql1, s1);


        String[] s2 = new String[]{"0", bname};
        String hql2 = "from Book where state=? and bookname =?";
        this.list = DBO.queryByPage(hql2, s2, 1, 10);


        System.out.println(list);

        return SUCCESS;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }

    private String bname = null;

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }
}
