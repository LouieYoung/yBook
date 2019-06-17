<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/1
  Time: 21:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>


  <%--  获取公共头部--%>
  <%@ include file="iframe/head.jsp"%>
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
          <div class="col-sm-5">新闻公告</div>
          <div class="col-sm-7 text-right">
            <a href="userDetail.jsp">进入用户中心</a>
          </div>
        </div>
      </div>
      <!-- Table -->

      <table class="table table-bordered table-hover">
        <tr>
          <th>标题</th>
          <th>内容</th>
          <th>日期</th>
          <th>操作</th>
        </tr>
        <s:iterator value="afficheList">
        <tr>
          <th><s:property value="title"/></th>
          <th><s:property value="content"/></th>
          <th><s:property value="addtime"/></th>
          <td><a href="affichelist.action">查看详情</a></td>
          </s:iterator>
        <tr>
      </table>
    </div>
  </div>

</div>




  <%--  获取公共尾部--%>
  <%@ include file="iframe/foot.jsp"%>


