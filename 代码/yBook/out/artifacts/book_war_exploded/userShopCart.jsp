<%@ taglib prefix="s" uri="/struts-tags" %>
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

<div class="container-fluid">
    <div class="row">
        <%--  获取公共左部--%>
        <%@ include file="iframe/userleft.jsp" %>


        <div class="col-sm-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-5">购物车</div>
                        <%--<div class="col-sm-7 text-right">
                            <a href="xinjian.html">新建工资项目</a>
                        </div>--%>
                    </div>
                </div>
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>名称</th>
                        <th>类型</th>
                        <th>价格</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="list">
                    <tr>
                        <th><s:property value="bookname"/></th>
                        <th><s:property value="booktype.type"/></th>
                        <th><s:property value="price"/></th>
                        <td>
                            <s:url id="url_put" value="cartlist2.action">
                                <s:param name="id" value="id"/>
                            </s:url>
                            <s:a href="%{url_put}">放入预订单</s:a>

                            <s:url id="url_delete" value="deletecart.action">
                                <s:param name="id" value="id"/>
                            </s:url>
                            <s:a href="%{url_delete}">删除</s:a>
                            <s:url id="url_detail" value="bookdetail.action">
                                <s:param name="bookid" value="id"/>
                            </s:url>
                            <s:a href="%{url_detail}">查看详情</s:a>
                        </td>
                        </s:iterator>
                    </tr>
                </table>
            </div>
            <nav aria-label="Page navigation">

                <ul class="pagination">

                    <li>
                        <s:url id="url_pre" value="cartlist.action">
                            <s:param name="pageNow" value="pageNow-1"/>
                        </s:url>
                        <s:a href="%{url_pre}">
                            <span aria-hidden="true">&laquo;</span>
                        </s:a>
                    </li>

                    <s:iterator var="i" begin="1" end="maxPage" step="1">
                        <s:if test="pageNow==#i">
                            <li class="active">

                        </s:if>
                        <s:else>
                            <li>
                        </s:else>
                        <s:url id="url_page" value="cartlist.action">
                            <s:param name="pageNow" value="i"/>
                        </s:url>
                        <s:a href="%{url_page}">
                        <span>
                            <s:property value="i"/>
                        </span>
                        </s:a>
                        </li>
                    </s:iterator>


                    <li>
                        <s:url id="url_next" value="cartlist.action">
                            <s:param name="pageNow" value="pageNow+1"/>
                        </s:url>
                        <s:a href="%{url_next}">
                            <span aria-hidden="true">&raquo;</span>
                        </s:a>
                    </li>

                </ul>
            </nav>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-5">预订单</div>
                        <%--<div class="col-sm-7 text-right">
                            <a href="xinjian.html">新建工资项目</a>
                        </div>--%>
                    </div>
                </div>
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>名称</th>
                        <th>类型</th>
                        <th>价格</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="list2">
                    <tr>
                        <th><s:property value="bookname"/></th>
                        <th><s:property value="booktype.type"/></th>
                        <th><s:property value="price"/></th>
                        <td>
                            <s:url id="url_put" value="cartlist0.action">
                                <s:param name="id" value="id"/>
                            </s:url>
                            <s:a href="%{url_put}">移出预订单</s:a>
                            <s:url id="url_detail" value="bookdetail.action">
                                <s:param name="bookid" value="id"/>
                            </s:url>
                            <s:a href="%{url_detail}">查看详情</s:a>
                        </td>
                        </s:iterator>
                    </tr>
                </table>
            </div>
            <form action="${pageContext.request.contextPath}/orderok.action" method="post">
                <div class="input-group">
                    <input type="text" name="place" class="form-control" placeholder="交易地点" aria-describedby="basic-addon2" required="required">
                </div>
                <input type="submit" value="确认订单" class="btn btn-default"/>
            </form>

        </div>
    </div>

</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>

