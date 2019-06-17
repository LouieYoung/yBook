<%--
  Created by IntelliJ IDEA.
  User: han
  Date: 2019/06/09
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--  获取公共头部--%>
<%@ include file="iframe/head.jsp" %>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">个人中心</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="#">欢迎，admin</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
<div class="container-fluid">
    <div class="row">
        <%--  获取公共左部--%>
        <%@ include file="iframe/userleft.jsp" %>


        <div class="col-sm-10">
            <div class="panel panel-default"><!--右侧的列表 -->
                <div class="panel-heading">
                    <h3 class="panel-title">修改密码</h3>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/changepassword.action" method="post">
                        <div class="form-group">
                            <label for="inputPassword1" class="col-sm-2 control-label" >
                                <span >原密码</span>
                                <span style="color:red;">*</span>
                            </label>
                            <div class="col-sm-10">
                                <input type="password" name="password" class="form-control" id="inputPassword1" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword2" class="col-sm-2 control-label">
                                <span >新密码</span>
                                <span style="color:red;">*</span>
                            </label>
                            <div class="col-sm-10">
                                <input type="password" name="newpassword" class="form-control" id="inputPassword2" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">
                                <span >确认密码</span>
                                <span style="color:red;">*</span>
                            </label>
                            <div class="col-sm-10">
                                <input type="password" name="repeatpassword" class="form-control" id="inputPassword3" required="required">
                            </div>
                        </div>
                        <div class="alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <strong>恭喜你</strong>修改成功。
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交</button>
                                <button type="reset" class="btn btn-default col-sm-offset-3">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>

