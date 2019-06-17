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

<div class="container-fluid">
    <div class="row">



        <div class="col-sm-10">
            <div class="panel panel-default col-sm-offset-2">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-5">留言板信息</div>
                    </div>
                </div>
                <!-- Table -->
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>用户名</th>
                        <th>用户邮箱</th>
                        <th>留言板内容</th>
                        <th>添加时间</th>

                    </tr>
                    <s:iterator value="list">
                    <tr>
                        <th><s:property value="nickname"/></th>
                        <th><s:property value="email"/></th>
                        <th><s:property value="content"/></th>
                        <th><s:property value="adddate"/></th>
                        </s:iterator>
                    </tr>
                </table>
            </div>
            <div class="col-sm-offset-2">
                <nav aria-label="Page navigation">

                        <ul class="pagination">

                            <li>
                                <s:url id="url_pre" value="guestbooklist.action">
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
                                <s:url id="url_page" value="guestbooklist.action">
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
                                <s:url id="url_next" value="guestbooklist.action">
                                    <s:param name="pageNow" value="pageNow+1"/>
                                </s:url>
                                <s:a href="%{url_next}">
                                    <span aria-hidden="true">&raquo;</span>
                                </s:a>
                            </li>

                        </ul>
                    </nav>
            </div>
            <div class="panel panel-default col-sm-offset-2">
                <!-- Default panel contents -->
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-5">你的留言</div>
                    </div>
                </div>
                <form class="form-horizontal" method="post" action="guestbooklist1.action" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="inputText1" class="col-sm-2 control-label">游客名称</label>
                        <div class="col-sm-3">
                            <input name="guestname" type="text" class="form-control" id="inputText1" required="required">
                        </div>
                        <label for="inputText2" class="col-sm-1 control-label">你的邮箱</label>
                        <div class="col-sm-3">
                            <input name="email" type="text" class="form-control" id="inputText2" required="required">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputText3" class="col-sm-2 control-label">内容</label>
                        <div class="col-sm-10">
                            <textarea name="context" cols="104" rows="10" id="inputText3" required="required">在这里输入内容...</textarea>
                        </div>
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
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.12.4.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>