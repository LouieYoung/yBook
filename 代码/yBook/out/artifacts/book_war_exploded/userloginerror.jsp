<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/8
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--  获取公共头部--%>
<%@ include file="iframe/head.jsp"%>

<div class="container">
    <div class="col-md-3 col-md-offset-4">

        <div class="panel panel-default">
            <div class="panel-heading">用户登录</div>
            <div class="panel-body" >
                <form action="${pageContext.request.contextPath}/login.action" method="post">
                    <br>
                    <span>用户名：</span>
                    <br>
                    <div class="input-group">
                        <input type="text" name="username" class="form-control" placeholder="Username" aria-describedby="basic-addon1">
                    </div>
                    <br>
                    <span>密码：</span>
                    <br>
                    <div class="input-group">
                        <input type="password" name="password" class="form-control" placeholder="Password" aria-describedby="basic-addon2">
                    </div>
                    <br>
                    <div class="alert alert-warning alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        <strong>登录失败</strong>请检查你的用户名密码是否正确。
                    </div>
                    <br>
                    <div class="input-group">
                        <input type="submit" value="登录" class="form-control" placeholder="Submit" aria-describedby="basic-addon3">
                        <br>
                        <span>还没有账户？</span>
                        <a href="userregist.jsp">现在注册</a>

                    </div>
                    <br>
                </form>
            </div>
        </div>

    </div>
</div>

<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp"%>