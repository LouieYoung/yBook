package com.action;

import com.entity.Order;
import com.entity.User;
import com.util.DBO;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class EffectiveOrderAction {
    private List<Order> list=new ArrayList<Order>();
    private int pageNow=1;
    private int maxSize;
    private int pageSize=10;
    private int maxPage;

    public String effectiveorder(){
        HttpServletRequest request= ServletActionContext.getRequest();
        User user =(User)request.getSession().getAttribute("user");

        String s[]=new String[]{String.valueOf(user.getId())};
        String hql="from Order where user.id=?";
        setMaxSize(DBO.getCount(hql,s));
        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage(hql,s,pageNow,pageSize);
            for (Order order : list) {
                System.out.println(order);
            }
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage(hql,s,pageNow,pageSize);
            for (Order order : list) {
                System.out.println(order);
            }
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage(hql,s,pageNow,pageSize);
            for (Order order : list) {
                System.out.println(order);
            }
            return SUCCESS;
        }
        return SUCCESS;
    }

    public String adminorderlist(){

        String s[]=new String[]{};
        String hql="from Order";
        setMaxSize(DBO.getCount(hql,s));
        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage(hql,s,pageNow,pageSize);
            for (Order order : list) {
                System.out.println(order);
            }
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage(hql,s,pageNow,pageSize);
            for (Order order : list) {
                System.out.println(order);
            }
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage(hql,s,pageNow,pageSize);
            for (Order order : list) {
                System.out.println(order);
            }
            return SUCCESS;
        }
        return SUCCESS;
    }


    public List<Order> getList() {
        return list;
    }

    public void setList(List<Order> list) {
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
}
