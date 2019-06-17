package com.action;

import com.entity.Book;
import com.entity.Order;
import com.entity.User;
import com.util.DBO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class AdmingeneralusermanageAction {
    private List<User> list=new ArrayList<User>();
    private int pageNow=1;
    private int maxSize;
    private int pageSize=10;
    private int maxPage;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
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

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String adminmanage(){

        String s[]=new String[]{};
        setMaxSize(DBO.getCount("from User",s));
        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage("from User",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage("from User",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage("from User",s,pageNow,pageSize);
            return SUCCESS;
        }
        return SUCCESS;
    }
    public String deleteuesr(){

        User user =(User) DBO.get(User.class,id);
        Set<Order> set = user.getOrderSet();
        for (Order order : set) {
            DBO.delete(order);
        }
        DBO.delete(user);
        adminmanage();
        return SUCCESS;
    }

    public String deletebook(){

        Book book =(Book) DBO.get(Book.class,id);
        DBO.delete(book);
        admingeneralbookmanage();
        return SUCCESS;
    }

    public String admingeneralbooktype(){
        String s[]=new String[]{};
        setMaxSize(DBO.getCount("from Booktype",s));
        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage("from Booktype",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage("from Booktype",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage("from Booktype",s,pageNow,pageSize);
            return SUCCESS;
        }
        return SUCCESS;

    }
    public String admingeneralbookmanage(){
        String s[]=new String[]{};
        setMaxSize(DBO.getCount("from Book",s));
        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage("from Book",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage("from Book",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage("from Book",s,pageNow,pageSize);
            return SUCCESS;
        }
        return SUCCESS;
    }
}
