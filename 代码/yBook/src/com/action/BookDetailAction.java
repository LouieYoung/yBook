
package com.action;

import com.entity.Book;
import com.entity.Booktype;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;
import java.util.ArrayList;
import java.util.List;

public class BookDetailAction extends ActionSupport {
    private List<Book> list = new ArrayList();
    private int bookid=1;


    public String bookdetail() {
        int[] s = new int[]{bookid};
        String hql = "from Book where id=?";
        list.add((Book)DBO.queryOne(hql,s));
        System.out.println(list);

        return SUCCESS;
    }



    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
}
