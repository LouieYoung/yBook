package com.action;

import com.entity.Admin;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.util.DBO;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class AdminLoginAction extends ActionSupport implements ModelDriven<Admin> {
    private Admin admin = new Admin();


    public String login() {
        System.out.println(this.admin);
        HttpServletRequest request = ServletActionContext.getRequest();
        String[] s = new String[]{this.admin.getUsername(), this.admin.getPassword()};
        String sql = "from Admin where username=? and password =?";
        Admin admin1 = (Admin) DBO.queryOne(sql, s);
        if (admin1 != null) {
            if (admin1.getType().equals("1")) {
                request.getSession().setAttribute("admin", admin1);
                return "systemadmin";
            } else {
                return "admin";
            }
        } else {
            return "error";
        }
    }

    public AdminLoginAction() {
    }

    public Admin getModel() {
        return this.admin;
    }

}
