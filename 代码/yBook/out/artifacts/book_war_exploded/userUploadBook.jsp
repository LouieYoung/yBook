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
            <div class="panel panel-default"><!--右侧的列表 -->
                <div class="panel-heading">
                    <h3 class="panel-title">上传书籍</h3>
                </div>
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/addbook.action" method="post" enctype="multipart/form-data">
<%--                    <form class="form-horizontal" method="post" action="/book/UploadServlet" enctype="multipart/form-data">--%>
                        <div class="form-group">
                            <label for="inputText" class="col-sm-2 control-label">书籍名称</label>
                            <div class="col-sm-6">
                                <input type="text" name="bookname" class="form-control" id="inputText" required="required">
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label for="inputType" class="col-sm-2 control-label">书籍类型</label>
                            <div class="col-sm-6">
                                <select class="form-control" id="inputType" name="booktype" required="required">
                                    <option>请选择...</option>
                                    <s:iterator value="typelist">
                                        <option><s:property value="type"/></option>
                                    </s:iterator>
                                </select>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label for="inputText2" class="col-sm-2 control-label">书籍价格</label>
                            <div class="col-sm-6">
                                <input type="number" name="price" class="form-control" id="inputText2" required="required">
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label for="inputText3" class="col-sm-2 control-label">书籍简介</label>
                            <div class="col-sm-10">
                                <textarea name="introduction"  cols="104" rows="10" id="inputText3" required="required">在这里输入内容...</textarea>>
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <label for="inputText4" class="col-sm-2 control-label">书籍图片</label>
                            <div class="col-sm-4">
                                <input type="file" name="picImg" class="form-control" id="inputText4">
                            </div>
                        </div>
                        <br>
                        <br>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <input type="submit" class="btn btn-default" value="提交"></input>
                            </div>
                        </div>
                        <br>
                        <br>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>

