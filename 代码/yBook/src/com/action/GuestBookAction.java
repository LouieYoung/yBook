package com.action;

import com.entity.Guestbook;
import com.util.DBO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class GuestBookAction {
    private List<Guestbook> list=new ArrayList<Guestbook>();
    private int pageNow=1;
    private int maxSize;
    private int pageSize=10;
    private int maxPage;
    private String guestname;
    private String email;
    private String context;

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<Guestbook> getList() {
        return list;
    }

    public void setList(List<Guestbook> list) {
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

    public String handleliuyan(){
        Guestbook guestbook = new Guestbook();
        guestbook.setAdddate(new Date(System.currentTimeMillis()));
        guestbook.setContent(getContext());
        guestbook.setEmail(getEmail());
        guestbook.setNickname(getGuestname());
        DBO.add(guestbook);
        guestbook();
        return SUCCESS;
    }

    public String guestbook(){

        String s[]=new String[]{};
        setMaxSize(DBO.getCount("from Guestbook",s));
        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage("from Guestbook",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage("from Guestbook",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage("from Guestbook",s,pageNow,pageSize);
            return SUCCESS;
        }
        return SUCCESS;
    }

    public String adminguestbook(){

        String s[]=new String[]{};
        setMaxSize(DBO.getCount("from Guestbook",s));
        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage("from Guestbook",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage("from Guestbook",s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage("from Guestbook",s,pageNow,pageSize);
            return SUCCESS;
        }
        return SUCCESS;
    }

    private int gid;

    public String adminguestbookdelete(){

        int[] s = new int[]{gid};
        String hql = "from Guestbook where id=?";
        list= DBO.queryByPage(hql,s,pageNow,pageSize);
        Guestbook guestbook=(Guestbook) DBO.queryOne(hql,s);

        DBO.delete(guestbook);
        return SUCCESS;

    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }
}
