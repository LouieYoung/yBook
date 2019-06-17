package com.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class AdminAction extends ActionSupport {
    public String login(){
        HttpServletRequest request = ServletActionContext.getRequest();
        Object obj = request.getSession().getAttribute("admin");
        if(obj != null){
            //登录状态判断
            return SUCCESS;
        }else{
            return ERROR;
        }
    }

}
