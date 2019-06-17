package com.action;

import com.entity.Book;
import com.entity.Booktype;
import com.entity.User;
import com.util.DBO;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class AlreadyUploadAction {
    private List<Book> list=new ArrayList<Book>();
    private List<Booktype> booktypelist = new ArrayList();
    private int pageNow=1;
    private int maxSize;
    private int pageSize=10;
    private int maxPage;
    private int typeSize;


    public String alreadybook(){
        HttpServletRequest request= ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");

        String s[]=new String[]{String.valueOf(user.getId())};
        String hql="from Book where uid=?";
        this.booklist=DBO.query(hql,s);
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
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage(hql,s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage(hql,s,pageNow,pageSize);
            return SUCCESS;
        }
        return SUCCESS;
    }


    private String bname;
    private List<Book> booklist = new ArrayList();



    public String search(){
        HttpServletRequest request= ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");

        String s1[]=new String[]{String.valueOf(user.getId())};
        String hql="from Book where uid=?";
        this.booklist=DBO.query(hql,s1);


        String s[]=new String[]{String.valueOf(user.getId()),bname};
        String hql2="from Book where uid=? and bookname=?";
        setMaxSize(DBO.getCount(hql2,s));
        System.out.println(getMaxSize());
        int a=0;
        if(maxSize%pageSize>0){
            a=1;
        }

        setMaxPage(maxSize/pageSize+a);
        if(pageNow==maxPage+1){
            setPageNow(pageNow-1);
            list= DBO.queryByPage(hql2,s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow==0){
            setPageNow(pageNow+1);
            list= DBO.queryByPage(hql2,s,pageNow,pageSize);
            return SUCCESS;
        }
        else if(pageNow>0&&pageNow<=maxPage){
            list= DBO.queryByPage(hql2,s,pageNow,pageSize);
            return SUCCESS;
        }
        return SUCCESS;
    }

//    private int bookid;
//    public String bookchange(){
//        int[] s = new int[]{bookid};
//        String hql = "from Book where id=?";
//        list.add((Book)DBO.queryOne(hql,s));
//        System.out.println(list);
//        return SUCCESS;
//    }

//    private String type;
//    private Double price;
//    private String bookname;
//    private String introduction;


//    public String bookchanged(){
//        int[] s = new int[]{bookid};
//        String hql = "from Book where id=?";
//        Book book=(Book)DBO.queryOne(hql,s);
////        if(book.getState()!=0){
//            book.toString();
////        }else {
//            Book book1=new Book();
//
//            book1.setState(0);
//
//            Booktype booktype1 = new Booktype();
//            String s2[] = new String[]{type};
//            hql = "from Booktype where type=?";
//            booktype1 = (Booktype) DBO.queryOne(hql, s2);
//            book1.setBooktype(booktype1);
//
//            book1.setId(book.getId());
//            book1.setState(book.getState());
//            book1.setUid(book.getUid());
//            book1.setCid(book.getCid());
//            book1.setAdddate(book.getAdddate());
//            book1.setOrder(book.getOrder());
//            book1.setIntroduction(introduction);
//            book1.setBookname(bookname);
//            book1.setPrice(price);
//            book1.setPic(book.getPic());
//
//            DBO.update(book1);
//
//
//        return SUCCESS;
//    }

    private int bookid;

    public String bookdelete(){
        int[] s = new int[]{bookid};
        String hql = "from Book where id=?";
        Book book=(Book)DBO.queryOne(hql,s);
        if(book.getState()!=0){
            return ERROR;
        }
        System.out.println(book);
        DBO.delete(book);
        alreadybook();
        return SUCCESS;
    }

//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public String getBookname() {
//        return bookname;
//    }
//
//    public void setBookname(String bookname) {
//        this.bookname = bookname;
//    }
//
//    public String getIntroduction() {
//        return introduction;
//    }
//
//    public void setIntroduction(String introduction) {
//        this.introduction = introduction;
//    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
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

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public List<Booktype> getBooktypelist() {
        return booktypelist;
    }

    public void setBooktypelist(List<Booktype> booktypelist) {
        this.booktypelist = booktypelist;
    }

    public int getTypeSize() {
        return typeSize;
    }

    public void setTypeSize(int typeSize) {
        this.typeSize = typeSize;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }
}
