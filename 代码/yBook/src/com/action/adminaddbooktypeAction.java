package com.action;

import com.entity.Booktype;
import com.util.DBO;

import static com.opensymphony.xwork2.Action.SUCCESS;

public class adminaddbooktypeAction {
    private String booktype;
    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }
    public String adminaddbooktype(){
        Booktype bk = new Booktype();
        bk.setType(booktype);
        DBO.add(bk);
        return SUCCESS;

    }

}
