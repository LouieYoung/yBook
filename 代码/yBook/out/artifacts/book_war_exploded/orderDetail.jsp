<%@ taglib prefix="S" uri="/struts-tags" %>
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

<div class="container">
    <div class="row">
            <%--  获取公共左部--%>
            <%@ include file="iframe/userleft.jsp" %>
            <div class="col-sm-10"><!--右侧的列表 -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-sm-5">订单详情</div>
                                <%--<div class="col-sm-7 text-right">
                                    <a href="xinjian.html">新建工资项目</a>
                                </div>--%>
                            </div>
                        </div>
                        <table class="table table-bordered table-hover">
                            <tr>
                                <th>订单号</th>
                                <th>创建时间</th>
                                <th>交货地点</th>
                            </tr>
                            <s:iterator value="order">
                            <tr>
                                <th><s:property value="id"/></th>
                                <th><s:property value="date"/></th>
                                <th><s:property value="place"/></th>
                            </s:iterator>
                            </tr>
                            <tr>
                                <th>名称</th>
                                <th>类型</th>
                                <th>价格</th>
                            </tr>
                            <s:iterator value="list">
                            <tr>
                                <th><s:property value="bookname"/></th>
                                <th><s:property value="booktype.type"/></th>
                                <th><s:property value="price"/></th>
                            </tr>
                            </s:iterator>
                        </table>
                    </div>

<%--                    <div class="panel panel-default">--%>
<%--                        <div class="panel-body">--%>

<%--                            <div class="col-sm-5">--%>
<%--                                <dt>订单详情：</dt>--%>
<%--                            </div>--%>
<%--                            <div class="col-sm-5">--%>
<%--                                <s:iterator value="list">--%>

<%--                                <dl class="dl-horizontal">--%>
<%--                                    <br>--%>
<%--                                    <br>--%>
<%--                                    <br>--%>
<%--                                    <br>--%>
<%--                                    <dt>书籍名称：</dt>--%>
<%--                                    <dd>--%>
<%--                                        <s:property value="bookname"/>--%>
<%--                                    </dd>--%>
<%--                                    <br>--%>
<%--                                    <br>--%>
<%--                                    <dt>书籍类型：</dt>--%>
<%--                                    <dd>--%>
<%--                                        <s:property value="booktype.type"/>--%>
<%--                                    </dd>--%>
<%--                                    <br>--%>
<%--                                    <br>--%>
<%--                                    <dt>价格：</dt>--%>
<%--                                    <dd>--%>
<%--                                        <s:property value="price"/>--%>
<%--                                    </dd>--%>
<%--                                    <br>--%>
<%--                                    <br>--%>
<%--                                    <dt>介绍：</dt>--%>
<%--                                    <dd>--%>
<%--                                        <s:property value="introduction"/>--%>
<%--                                    </dd>--%>
<%--                                    <br>--%>
<%--                                    <br>--%>
<%--                                </dl>--%>
<%--                                </s:iterator>--%>

<%--                            </div>--%>
<%--                        </div>--%>

<%--                    </div>--%>

            </div>
    </div>

</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>

