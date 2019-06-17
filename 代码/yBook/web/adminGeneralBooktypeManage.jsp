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

<%@ include file="adminGeneralHead.jsp" %>
<div class="container-fluid">
    <div class="row">
        <%@ include file="adminGeneralLeft.jsp" %>



        <div class="col-sm-10">
            <div class="panel panel-default">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-5">书籍类型信息</div>
                    </div>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>类型id</th>
                        <th>书籍类型名称</th>
                        <th>书籍数量</th>
                    </tr>
                    <s:iterator value="list">
                    <tr>
                        <th><s:property value="id"/></th>
                        <th><s:property value="type"/></th>
                        <th><s:property value="bookSet.size()"/></th>
                        </s:iterator>
                    </tr>
                </table>
            </div>
            <nav aria-label="Page navigation">

                <ul class="pagination">

                    <li>
                        <s:url id="url_pre" value="admingeneralbooktypemanage.action">
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
                        <s:url id="url_page" value="admingeneralbooktypemanage.action">
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
                        <s:url id="url_next" value="admingeneralbooktypemanage.action">
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