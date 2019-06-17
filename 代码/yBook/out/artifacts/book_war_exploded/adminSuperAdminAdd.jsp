<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/06/11
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--  获取公共头部--%>
<%@ include file="iframe/head.jsp" %>

<%@ include file="adminSuperHead.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="adminSuperLeft.jsp" %>



        <div class="col-sm-10">
            <div class="panel panel-default"><!--左侧的列表 -->
                <div class="panel-heading">
                    <h3 class="panel-title">新建管理员</h3>
                </div>
                <div class="panel-body  ">
                    <form class="form-horizontal" action="${pageContext.request.contextPath}/adminsuperadminadd.action" method="post">
                        <div class="form-group">
                            <label for="inputEmail1" class="col-sm-2 control-label">管理员名</label>
                            <div class="col-sm-10">
                                <input type="text" name="username" class="form-control" id="inputEmail1">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail2" class="col-sm-2 control-label">管理员密码</label>
                            <div class="col-sm-10">
                                <input type="text" name="password" class="form-control" id="inputEmail2">
                            </div>
                        </div>
<%--                        <div class="form-group">--%>
<%--                            <label for="inputEmail2" class="col-sm-2 control-label">管理员类型</label>--%>
<%--                            <div class="col-sm-10">--%>
<%--                                <input type="text" class="form-control" id="inputEmail3">--%>
<%--                            </div>--%>
<%--                        </div>--%>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">提交</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>



    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</div>

<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>