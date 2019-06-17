package com.action;

import com.entity.Book;
import com.entity.Order;
import com.entity.User;
import com.util.DBO;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class ShopCartAction {
    private List<Book> list=new ArrayList<Book>();
    private List<Book> list2=new ArrayList<Book>();
    private int pageNow=1;
    private int maxSize;
    private int pageSize=10;
    private int maxPage;
    private int id;
    private int state;
    private String place;

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<Book> getList2() {
        return list2;
    }

    public void setList2(List<Book> list2) {
        this.list2 = list2;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageNow() {
        return pageNow;
    }



    public String cartbook(){
        HttpServletRequest request= ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");


        String s[]=new String[]{String.valueOf(user.getId()),"0"};
        String s2[]=new String[]{String.valueOf(user.getId()),"2"};
        setMaxSize(DBO.getCount("from Book where cid=? and state =?",s));
        list2= DBO.queryByPage("from Book where cid=? and state =?",s2,1,10);

        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage("from Book where cid=? and state =?",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage("from Book where cid=? and state =?",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage("from Book where cid=? and state =?",s,pageNow,pageSize);
            return SUCCESS;
        }
        return SUCCESS;
    }
    public String cartbook2(){
        Book book =(Book) DBO.get(Book.class,id);
        book.setState(2);
        DBO.update(book);
        cartbook();
        return SUCCESS;
    }
    public String cartbook1(){
        HttpServletRequest request = ServletActionContext.getRequest();
        User user =(User) request.getSession().getAttribute("user");
        if(user==null)return ERROR;
        Book book =(Book) DBO.get(Book.class,id);
        book.setCid(user.getId());
        DBO.update(book);
        cartbook();
        return SUCCESS;
    }
    public String cartbook0(){
        Book book =(Book) DBO.get(Book.class,id);
        book.setState(0);
        DBO.update(book);
        cartbook();
        return SUCCESS;
    }
    public String deletecart(){
        Book book =(Book) DBO.get(Book.class,id);
        book.setCid(-1);
        DBO.update(book);
        cartbook();
        return SUCCESS;
    }
    public String orderok(){
        Order order=new Order();
        HttpServletRequest request = ServletActionContext.getRequest();
        User user =(User) request.getSession().getAttribute("user");
        order.setUser(user);
        String s2[]=new String[]{String.valueOf(user.getId()),"2"};
        list2= DBO.queryByPage("from Book where cid=? and state =?",s2,1,10);

        for (Book book : list2) {

            book.setState(1);
            DBO.update(book);
            order.getBookSet().add(book);
        }
        order.setDate(new Date(System.currentTimeMillis()));
        order.setPlace(place);
        DBO.add(order);
        cartbook();
        return SUCCESS;

    }
}
