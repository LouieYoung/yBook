  User: Administrator
  Date: 2019/6/9
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/06/09
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--获取管理员头部--%>
<%@ include file="iframe/adminhead.jsp"%>

<div class="container-fluid">
    <div class="row">
        <%--获取超级管理员左部--%>
        <%@ include file="iframe/adminleft.jsp"%>

        <div class="col-sm-10">
            <div class="panel panel-default"><!--右侧的列表 -->
                <div class="panel-heading">
                    <h3 class="panel-title">新建公告</h3>
                </div>
                <div class="panel-body  ">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label for="inputEmail1" class="col-sm-2 control-label">公告标题</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail1">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail2" class="col-sm-2 control-label">公告内容</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputEmail2">
                            </div>
                        </div>
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
</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>