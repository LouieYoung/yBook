<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/11
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--  获取公共头部--%>
<%@ include file="iframe/head.jsp" %>

<div class="container">
    <div class="col-sm-2">
        <ul class="nav nav-pills nav-stacked">
            <s:iterator value="booktypelist">
                <s:url id="url_type" value="booktypelist.action" method="post">
                    <s:param name="booktypeidNow" value="id"></s:param>
                </s:url>
                <li role="presentation">
                    <s:a href="%{url_type}"><s:property value="type"/></s:a>
                </li>
            </s:iterator>
        </ul>
    </div>


    <div class="col-sm-10">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading">
                <div class="row">
                    <div class="col-sm-5">
                        <s:iterator value="booktypelist">
                            <s:if test="booktypeidNow==id">
                                <s:property value="type"></s:property>
                            </s:if>
                        </s:iterator>
                    </div>
                    <div class="col-sm-7 text-right">
                        <s:url id="url_put" value="cartlist.action">
                        </s:url>
                        <s:a href="%{url_put}">进入购物车</s:a>
                    </div>
                </div>
            </div>
            <!-- Table -->
            <table class="table table-bordered table-hover">
                <tr>
                    <th>书籍名称</th>
                    <th>书籍类型</th>
                    <th>书籍价格</th>
                    <th>上架日期</th>
                    <th>书籍介绍</th>

                    <th>操作</th>
                </tr>
                <s:iterator value="list">
                <tr>
                    <th><s:property value="bookname"/></th>
                    <th><s:property value="booktype.type"/></th>
                    <th><s:property value="price"/></th>
                    <th><s:property value="adddate"/></th>
                    <th><s:property value="introduction"/></th>
                    <td>
                        <s:url id="url_put" value="cartlist1.action">
                            <s:param name="id" value="id"/>
                        </s:url>
                        <s:a href="%{url_put}">加入购物车</s:a>
                        <s:url id="url_detail" value="bookdetail.action">
                            <s:param name="bookid" value="id"/>
                        </s:url>
                        <s:a href="%{url_detail}">查看详情</s:a>
                    </td>
                    </s:iterator>
                <tr>
            </table>
        </div>
        <nav aria-label="Page navigation">
            <ul class="pagination">

                <li>
                    <s:url id="url_pre" value="booktypelist.action">
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
                    <s:url id="url_page" value="booktypelist.action">
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
                    <s:url id="url_next" value="booktypelist.action">
                        <s:param name="pageNow" value="pageNow+1"/>
                    </s:url>
                    <s:a href="%{url_next}">
                        <span aria-hidden="true">&raquo;</span>
                    </s:a>
                </li>

            </ul>
        </nav>
    </div>
</div>


<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>
