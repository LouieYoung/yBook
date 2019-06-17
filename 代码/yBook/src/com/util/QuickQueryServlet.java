package com.util;

import com.entity.Book;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/QuickQueryServlet")
public class QuickQueryServlet extends HttpServlet {
    String s[] = new String[]{};
    List<Book> books = DBO.query("from Book", s);
    //获取所有的书名
    String names[] = new String[books.size()];
    //先转化为json对象数组，然后再将JSON对象数组转字符串输出
    String json4 = JSONArray.fromObject(names).toString();

    static private List<String> list = new ArrayList<String>();

    static {
        list.add("薛傻逼");
        list.add("薛之谦");
        list.add("凯逼");
        list.add("凯逼 是sb");
        list.add("ajax");
        list.add("ajax 教程");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String keyword = request.getParameter("keyword");
        List<String> res = new ArrayList<String>();

        for (String string : list) {
            if (string.contains(keyword)) {
                res.add(string);
            }
        }
        JSONArray jsonArray = JSONArray.fromObject(res);
        System.out.println(jsonArray.toString());
        response.setContentType("text/html");
        response.getWriter().write(jsonArray.toString());
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

    }

}
