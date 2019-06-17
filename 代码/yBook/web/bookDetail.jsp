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
        <div class="col-sm-10"><!--右侧的列表 -->
            <div class="panel panel-default">
                <div class="panel-heading">书籍详情</div>

                <s:iterator value="list">

                <div class="panel-body">
                    <table class="table">

                                <div class="panel-body col-sm-5">

                                    <script type="text/javascript">
                                        function resizeImage(obj){if(obj.height>100)obj.height=100;if(obj.width>100)obj.width=100; }

                                        var url = 'images/<s:property value="pic"/>';
                                        document.write('<img src="' + url + '" onload="resizeImage()"  width="385" height="350"/>');
                                    </script>
                                </div>

                                <div class="panel-body col-sm-5">
                                    <dl class="dl-horizontal">
                                        <br>
                                        <br>
                                        <br>
                                        <br>
                                        <dt>书籍名称：</dt>
                                        <dd>
                                            <s:property value="bookname"/>
                                        </dd>
                                        <br>
                                        <br>
                                        <dt>书籍类型：</dt>
                                        <dd>
                                            <s:property value="booktype.type"/>
                                        </dd>
                                        <br>
                                        <br>
                                        <dt>价格：</dt>
                                        <dd>
                                            <s:property value="price"/>
                                        </dd>
                                        <br>
                                        <br>
                                        <dt>介绍：</dt>
                                        <dd>
                                            <s:property value="introduction"/>
                                        </dd>
                                        <br>
                                        <br>
                                    </dl>
                                </div>
                        </tr>
                    </table>
                </div>
                </s:iterator>
            </div>

        </div>
    </div>

</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>

