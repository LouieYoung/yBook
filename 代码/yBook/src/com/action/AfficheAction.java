package com.action;

import com.entity.Admin;
import com.entity.Affiche;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AfficheAction extends ActionSupport {
    private List<Affiche> list = new ArrayList();
    private int pageNow = 1;
    private int maxSize;
    private int pageSize = 10;
    private int maxPage;
    private String title;
    private String context;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String afficheadd(){
        Affiche affiche = new Affiche();
        affiche.setContent(getContext());
        affiche.setAddtime(new Date(System.currentTimeMillis()));
        affiche.setTitle(getTitle());
        HttpServletRequest request= ServletActionContext.getRequest();

        Admin admin =(Admin) request.getSession().getAttribute("admin");
        affiche.setAdmin(admin);
        DBO.add(affiche);

        return SUCCESS;
    }

    public String deleteaffiche(){
        Affiche affiche =(Affiche) DBO.get(Affiche.class,id);
        DBO.delete(affiche);
        affiche();
        return SUCCESS;
    }

    public String affiche() {
        String[] s = new String[]{};
        String hql = "from Affiche";
        this.setMaxSize(DBO.getCount(hql, s));
        System.out.println(this.getMaxSize());
        int a = 0;
        if (this.maxSize % this.pageSize > 0) {
            a = 1;
        }

        this.setMaxPage(this.maxSize / this.pageSize + a);
        if (this.pageNow == this.maxPage + 1) {
            this.setPageNow(this.pageNow - 1);
            this.list = DBO.queryByPage(hql, s, this.pageNow, this.pageSize);
            return "success";
        } else if (this.pageNow == 0) {
            this.setPageNow(this.pageNow + 1);
            this.list = DBO.queryByPage(hql, s, this.pageNow, this.pageSize);
            return "success";
        } else if (this.pageNow > 0 && this.pageNow <= this.maxPage) {
            this.list = DBO.queryByPage(hql, s, this.pageNow, this.pageSize);
            return "success";
        } else {
            return "success";
        }
    }

    public String admingeneralaffiche() {
        String[] s = new String[]{};
        String hql = "from Affiche";
        this.setMaxSize(DBO.getCount(hql, s));
        System.out.println(this.getMaxSize());
        int a = 0;
        if (this.maxSize % this.pageSize > 0) {
            a = 1;
        }

        this.setMaxPage(this.maxSize / this.pageSize + a);
        if (this.pageNow == this.maxPage + 1) {
            this.setPageNow(this.pageNow - 1);
            this.list = DBO.queryByPage(hql, s, this.pageNow, this.pageSize);
            return "success";
        } else if (this.pageNow == 0) {
            this.setPageNow(this.pageNow + 1);
            this.list = DBO.queryByPage(hql, s, this.pageNow, this.pageSize);
            return "success";
        } else if (this.pageNow > 0 && this.pageNow <= this.maxPage) {
            this.list = DBO.queryByPage(hql, s, this.pageNow, this.pageSize);
            return "success";
        } else {
            return "success";
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setList(List<Affiche> list) {
        this.list = list;
    }

    public List<Affiche> getList() {
        return this.list;
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
}
