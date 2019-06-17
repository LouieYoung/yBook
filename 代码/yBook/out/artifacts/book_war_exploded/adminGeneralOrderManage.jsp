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
        <%@ include file="adminGeneralLeft.jsp" %>


        <div class="col-sm-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-5">已生效订单</div>
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
                        <th>订单内容</th>
                    </tr>
                    <s:iterator value="list">
                    <tr>
                        <th><s:property value="id"/></th>
                        <th><s:property value="date"/></th>
                        <th><s:property value="place"/></th>
                        <td>
                            <s:url id="url_detail" value="orderdetail.action">
                                <s:param name="orderid" value="id"/>
                            </s:url>
                            <s:a href="%{url_detail}">查看详情</s:a>                        </td>
                        </s:iterator>
                    </tr>
                </table>
            </div>

            <nav aria-label="Page navigation">

                <ul class="pagination">

                    <li>
                        <s:url id="url_pre" value="adminorderlist.action">
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
                        <s:url id="url_page" value="adminorderlist.action">
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
                        <s:url id="url_next" value="adminorderlist.action">
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
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</div>

<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>