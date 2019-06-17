//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class UserLoginAction extends ActionSupport {
    private String username;
    private String password;

    public UserLoginAction() {
    }

    public String login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String[] s = new String[]{this.username, this.password};
        String sql = "from User where username=? and password =?";
        User user1 = (User) DBO.queryOne(sql, s);
        if (user1 != null) {
            request.getSession().setAttribute("user", user1);
            return "success";
        } else {
            return "login";
        }
    }

    private String newpassword;
    private String repeatpassword;


    public String changepassword() {
        HttpServletRequest request = ServletActionContext.getRequest();
        User user1=(User)request.getSession().getAttribute("user");
        if((newpassword.equals(repeatpassword))&&(user1.getPassword().equals(password))){
            user1.setPassword(newpassword);
            DBO.update(user1);
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String logout(){
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("user",null);
        request.getSession().setAttribute("admin",null);
        return SUCCESS;
    }

    public String getRepeatpassword() {
        return repeatpassword;
    }

    public void setRepeatpassword(String repeatpassword) {
        this.repeatpassword = repeatpassword;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewpassword() {
        return newpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }
}
