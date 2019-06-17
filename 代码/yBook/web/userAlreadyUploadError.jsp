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
                        <h3 class="panel-title">已上传书籍查询</h3>
                    </div>

                    <div class="panel-body">
                            <form action="${pageContext.request.contextPath}/alreadyuploadsearch.action" method="post">

                                <div align="center" class="form-inline">
                                    <input type="text" name="bname" style="width:300px;height:34px;font-size:14pt;" id="o" onkeyup="autoComplete.start(event)">
                                    <input type="submit" value="搜索" class="form-control" placeholder="Submit" aria-describedby="basic-addon3">

                                </div>
                                <div class="auto_hidden" id="auto"><!--自动完成 DIV--></div>
                                <script>
                                    var s=new Array();
                                    <s:iterator value="booklist">
                                    s.push('<s:property value="bookname"/>');
                                    </s:iterator>
                                    var autoComplete=new AutoComplete('o','auto',s);
                                </script>
                                <br>
                                <br>
                            </form>

<%--                        <form class="form-horizontal" action="${pageContext.request.contextPath}/alreadyuploadsearch.action" method="post">--%>
<%--                            <div class="form-group">--%>
<%--                                <label class="col-sm-2 control-label">书籍名称</label>--%>
<%--                                <div class="col-sm-6">--%>
<%--                                    <div align="center" class="form-inline">--%>
<%--                                        <input type="text" name="bname" style="width:300px;height:34px;font-size:14pt;" id="o" onkeyup="autoComplete.start(event)">--%>
<%--                                        <input type="submit" value="搜索" class="form-control" placeholder="Submit" aria-describedby="basic-addon3">--%>

<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>

<%--                            <div class="auto_hidden" id="auto"><!--自动完成 DIV--></div>--%>
<%--                            <script>--%>
<%--                                var s=new Array();--%>
<%--                                <s:iterator value="booklist">--%>
<%--                                s.push('<s:property value="bookname"/>');--%>
<%--                                </s:iterator>--%>
<%--                                var autoComplete=new AutoComplete('o','auto',s);--%>
<%--                            </script>--%>
<%--                            <br>--%>
<%--                            <br>--%>
<%--                            <div class="form-group">--%>
<%--                                <label for="inputType" class="col-sm-2 control-label">书籍类型</label>--%>
<%--                                <div class="col-sm-6">--%>
<%--                                    <select name="booktype" class="form-control" id="inputType" required="required">--%>

<%--                                        <option>请选择...</option>--%>
<%--                                        <s:iterator value="booktypelist">--%>
<%--                                        <option>--%>
<%--                                            <s:property value="type"/>--%>
<%--                                        </option>--%>
<%--                                        </s:iterator>--%>
<%--                                    </select>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <label for="inputName" class="col-sm-2 control-label">是否已卖</label>--%>
<%--                                <div class="col-sm-6">--%>
<%--                                    <label class="radio-inline">--%>
<%--                                        <input type="radio" name="state" id="inlineRadio1" value="1"> 是--%>
<%--                                    </label>--%>
<%--                                    <label class="radio-inline">--%>
<%--                                        <input type="radio" name="state" id="inlineRadio2" value="0"> 否--%>
<%--                                    </label>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <div class="form-group">--%>
<%--                                <div class="col-sm-offset-2 col-sm-10">--%>
<%--                                    <button type="submit" class="btn btn-default">查询</button>--%>
<%--                                    <button type="reset" class="btn btn-default col-sm-offset-5">重置</button>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </form>--%>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-sm-5">已上传书籍列表</div>
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
                            <th>上传时间</th>
                            <th>是否已卖</th>
                            <th>介绍</th>
                            <th>所属订单</th>
                            <th>操作</th>
                        </tr>
                        <s:iterator value="list">
                        <tr>
                            <th><s:property value="bookname"/></th>
                            <th><s:property value="booktype.type"/></th>
                            <th><s:property value="price"/></th>
                            <th><s:property value="adddate"/></th>
                            <th>
                                <s:if test="state==0">否</s:if>
                                <s:if test="state==1">是</s:if>
                            </th>
                            <th><s:property value="introduction"/></th>
                            <th>
                                <s:if test="order==null">无</s:if>
                                <s:else><s:property value="order.id"/></s:else>
                            </th>
                            <td>
<%--                                <s:url id="url_change" value="bookchange.action">--%>
<%--                                    <s:param name="bookid" value="id"/>--%>
<%--                                </s:url>--%>
<%--                                <s:a href="%{url_change}">修改</s:a>--%>
                                <s:url id="url_delete" value="bookdelete.action">
                                    <s:param name="bookid" value="id"/>
                                </s:url>
                                <s:a href="%{url_delete}">删除</s:a>
                            </td>
                            </s:iterator>
                            <div class="alert alert-warning alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <strong>删除失败</strong>已卖掉的书无法删除。
                            </div>
                        </tr>
                    </table>
                </div>
                <%--页标签--%>
                <nav aria-label="Page navigation">

                    <ul class="pagination">

                        <li>
                            <s:url id="url_pre" value="alreadyuploadlist.action">
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
                            <s:url id="url_page" value="alreadyuploadlist.action">
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
                            <s:url id="url_next" value="alreadyuploadlist.action">
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

</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>

