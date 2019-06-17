
package com.action;

import com.entity.Book;
import com.entity.Order;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailAction extends ActionSupport {
    private List<Book> list = new ArrayList();
    private Order order = new Order();
    private int orderid = 1;


    public String orderdetail() {
        int[] s = new int[]{orderid};
        String hql = "from Book where oid=?";
        list = DBO.query(hql, s);
        String hql2 = "from Order where id=?";
        setOrder((Order) DBO.queryOne(hql2, s));
        System.out.println(list);


        return SUCCESS;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public List<Book> getList() {
        return list;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
}
