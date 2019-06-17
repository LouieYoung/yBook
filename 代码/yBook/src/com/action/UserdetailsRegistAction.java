//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.action;

import com.entity.Major;
import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

public class UserdetailsRegistAction extends ActionSupport {
    private String realname;
    private String sid;
    private String gender;
    private String phone;
    private String email;
    private String major;

    public String detailRegist() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        int a = (Integer)session.getAttribute("userid");
        User user1 = (User)DBO.get(User.class, a);
        user1.setRealname(this.realname);
        user1.setPhone(this.phone);
        user1.setSid(this.sid);
        user1.setEmail(this.email);
        user1.setGender(this.gender);
        String[] s = new String[]{this.major};
        Major m = (Major)DBO.queryOne("from Major where major=?", s);
        user1.setMajor(m);
        DBO.update(user1);
        return this.realname != null && this.major != null && this.phone != null && this.sid != null && this.email != null && this.gender != null ? "success" : "error";
    }

    public String datailChange() {
        HttpServletRequest request = ServletActionContext.getRequest();
        User user1=(User)request.getSession().getAttribute("user");
        user1.setRealname(this.realname);
        user1.setPhone(this.phone);
        user1.setSid(this.sid);
        user1.setEmail(this.email);
        user1.setGender(this.gender);
        String[] s = new String[]{this.major};
        Major m = (Major)DBO.queryOne("from Major where major=?", s);
        user1.setMajor(m);
        DBO.update(user1);
        return this.realname != null && this.major != null && this.phone != null && this.sid != null && this.email != null && this.gender != null ? "success" : "error";
    }

    public String getRealname() {
        return this.realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getSid() {
        return this.sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
