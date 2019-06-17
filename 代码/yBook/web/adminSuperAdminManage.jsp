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
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-5">管理员信息展示</div>
                    </div>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>管理员id</th>
                        <th>管理员名</th>
                        <th>管理员密码</th>
                        <th>管理员类型</th>
                        <th>操作</th>
                    </tr>
                    <s:iterator value="list">
                    <tr>
                        <th><s:property value="id"/></th>
                        <th><s:property value="username"/></th>
                        <th><s:property value="password"/></th>
                        <th>
                            <s:if test="type==1">
                                系统管理员
                            </s:if>
                            <s:elseif test="type==0">
                                普通管理员
                            </s:elseif>
                        </th>
                        <td>
                            <s:url id="url_detail" value="adminsuperadmindelete.action">
                                <s:param name="adminid" value="id"/>
                            </s:url>
                            <s:a href="%{url_detail}">删除</s:a>
                        </td>
                        </s:iterator>
                    <tr>
                </table>
            </div>
            <nav aria-label="Page navigation">
                <ul class="pagination">

                    <li>
                        <s:url id="url_pre" value="adminsuperadminlist.action">
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
                        <s:url id="url_page" value="adminsuperadminlist.action">
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
                        <s:url id="url_next" value="adminsuperadminlist.action">
                            <s:param name="pageNow" value="pageNow+1"/>
                        </s:url>
                        <s:a href="%{url_next}">
                            <span aria-hidden="true">&raquo;</span>
                        </s:a>
                    </li>

                </ul>
            </nav>




    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</div>

<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>