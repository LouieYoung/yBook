
package com.action;

import com.entity.Book;
import com.entity.Booktype;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookAction extends ActionSupport {
    private List<Book> list = new ArrayList();
    private List<Booktype> typelist = new ArrayList<Booktype>();

    private int pageNow = 1;
    private int maxSize;
    private int pageSize = 10;
    private int maxPage;

    public String book() {
        String[] s = new String[]{"0"};
        String hql = "from Book where state=?";
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


    private String booktype = "考研资料";
    private double price;
    private String bookname;
    private String introduction;
    private String picImgFileName;
    private File picImg;
    private String picImgContentType;


    public String addbook() {
        HttpServletRequest request = ServletActionContext.getRequest();
        User user = (User) request.getSession().getAttribute("user");

        Book book = new Book();
        book.setUid(user.getId());
        book.setAdddate(new Date(System.currentTimeMillis()));

        Booktype booktype1 = new Booktype();
        booktype1.setId(2);
        booktype1.setType("考研资料");
        String s[] = new String[]{booktype};
        String hql = "from Booktype where type=?";
        booktype1 = (Booktype) DBO.queryOne(hql, s);

        book.setBooktype(booktype1);
        book.setState(0);

        String filePath = ServletActionContext.getServletContext().getRealPath("/images");
        if (picImg != null) {
            String fileName;
            fileName = UUID.randomUUID().toString().replaceAll("-", "") +
                    picImgFileName.substring(picImgFileName.lastIndexOf("."));
            try {
                FileUtils.copyFile(picImg, new File(filePath, fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            book.setPic(fileName);
        }

        book.setPrice(price);
        book.setBookname(bookname);
        book.setIntroduction(introduction);
        DBO.add(book);
        return SUCCESS;
    }

    public String useruploadbook() {
        String[] s = new String[]{};
        String hql = "from Booktype";
        this.typelist = DBO.query(hql, s);
        return SUCCESS;
    }

    public List<Booktype> getTypelist() {
        return typelist;
    }

    public void setTypelist(List<Booktype> typelist) {
        this.typelist = typelist;
    }

    public List<Book> getList() {
        return this.list;
    }

    public void setList(List<Book> list) {
        this.list = list;
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

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPicImgFileName() {
        return picImgFileName;
    }

    public void setPicImgFileName(String picImgFileName) {
        this.picImgFileName = picImgFileName;
    }

    public File getPicImg() {
        return picImg;
    }

    public void setPicImg(File picImg) {
        this.picImg = picImg;
    }

    public String getPicImgContentType() {
        return picImgContentType;
    }

    public void setPicImgContentType(String picImgContentType) {
        this.picImgContentType = picImgContentType;
    }
}
