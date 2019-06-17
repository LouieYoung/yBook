//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.util.DBO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

public class UserRegistAction extends ActionSupport {
    private String username;
    private String password;
    private String repeatpassword;

    public String regist() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String[] s = new String[]{this.username, this.password};
        String sql1 = "from User where username=? and password =?";
        User user1 = (User)DBO.queryOne(sql1, s);
        if (user1 != null) {
            return "alreadyexits";
        } else if (this.password.length() < 6) {
            return "toosmall";
        } else if (!this.password.equals(this.repeatpassword)) {
            return "notsame";
        } else {
            User user2 = new User();
            user2.setPassword(this.password);
            user2.setUsername(this.username);
            DBO.add(user2);
            user1 = (User)DBO.queryOne(sql1, s);
            if (user1 != null) {
                request.getSession().setAttribute("userid", user1.getId());
                return "success";
            } else {
                return "error";
            }
        }
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

    public String getRepeatpassword() {
        return this.repeatpassword;
    }

    public void setRepeatpassword(String repeatpassword) {
        this.repeatpassword = repeatpassword;
    }
}
