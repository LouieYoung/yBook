<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/9
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>校园二手图书在线交易平台</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>



<div class="page-header" style="background:#f7f7f7">
    <nav class="navbar navbar-default">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->

            <!-- Collect the nav links, forms, and other content for toggling -->
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <button type="button" class="btn btn-default navbar-btn">
                        <a href="user.action">${sessionScope.admin.username}登录</a>
                    </button>
                    <button type="button" class="btn btn-default navbar-btn">
                        <a href="logout.action">退出登录</a>
                    </button>
                </li>
            </ul>
            <!-- /.navbar-collapse -->
            <!-- /.container-fluid -->
            <h2>HIT<small>  校园二手图书在线交易平台</small></h2>
        </div>

    </nav>
    <div class="container">

        <%--主菜单开始--%>
        <ul class="nav nav-pills">
            <li role="presentation"><a href="index.action">首页</a></li>
            <li role="presentation"><a href="affichelist.action">新闻公告</a></li>
            <li role="presentation"><a href="booklist.action">书籍信息</a></li>
            <li role="presentation"><a href="booktypelist.action">分类索引</a></li>
            <li role="presentation"><a href="quickquery.action">快速查询</a></li>
            <li role="presentation"><a href="guestbooklist.action">留言分享</a></li>
            <li role="presentation"><a href="user.action">用户中心</a></li>
            <li role="presentation"><a href="adminlogin.jsp">管理中心</a></li>

        </ul>
        <%--主菜单结束--%>

    </div>
</div>