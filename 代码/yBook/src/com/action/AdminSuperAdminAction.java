package com.action;


import com.entity.Admin;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;

import java.util.ArrayList;
import java.util.List;

public class AdminSuperAdminAction extends ActionSupport {

    private List<Admin> list=new ArrayList<Admin>();
    private int pageNow = 1;
    private int maxSize;
    private int pageSize = 10;
    private int maxPage;


    private String username;
    private String password;

    public String add(){
        String[] s = new String[]{this.username, this.password};
        String sql1 = "from Admin where username=? and password =?";
        Admin admin = (Admin) DBO.queryOne(sql1, s);
        if (admin != null) {
            return SUCCESS;
        } else {
            Admin admin1 = new Admin();
            admin1.setPassword(this.password);
            admin1.setUsername(this.username);
            admin1.setType("0");
            DBO.add(admin1);
        }
        return SUCCESS;
    }

    private int adminid;

    public String delete(){
        int[] s = new int[]{adminid};
        String hql = "from Admin where id=?";
        Admin admin=(Admin) DBO.queryOne(hql,s);
        DBO.delete(admin);
        String hql2 = "from Admin";
        list = DBO.queryByPage(hql2, s, pageNow, pageSize);

        return SUCCESS;
    }


    public String list() {

        String hql = "from Admin";
        String s[] = new String[]{};
        setMaxSize(DBO.getCount(hql, s));
        int a = 0;
        if (maxSize % pageSize > 0) {
            a = 1;
        }

        setMaxPage(maxSize / pageSize + a);
        if (pageNow == maxPage + 1) {
            setPageNow(pageNow - 1);
            list = DBO.queryByPage(hql, s, pageNow, pageSize);
            return SUCCESS;
        } else if (pageNow == 0) {
            setPageNow(pageNow + 1);
            list = DBO.queryByPage(hql, s, pageNow, pageSize);
            return SUCCESS;
        } else if (pageNow > 0 && pageNow <= maxPage) {
            list = DBO.queryByPage(hql, s, pageNow, pageSize);
            return SUCCESS;
        }
        return SUCCESS;

    }


    public List<Admin> getList() {
        return list;
    }

    public void setList(List<Admin> list) {
        this.list = list;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
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

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }
}
