<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/8
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--  获取公共头部--%>
<%@ include file="iframe/head.jsp"%>

<div class="container">
    <div class="col-md-3 col-md-offset-4">

        <div class="panel panel-default">
            <div class="panel-heading">详细资料填写</div>
            <div class="panel-body" >
                <form action="${pageContext.request.contextPath}/datailRegist.action" method="post">
                    <s:property value="uid"></s:property>
                    <br>
                    <span>真实姓名：</span>
                    <span style="color: red">*</span>
                    <br>
                    <div class="input-group">
                        <input type="text" name="realname" class="form-control" placeholder="Realname" aria-describedby="basic-addon1" required="required">
                    </div>
                    <br>
                    <span>专业：</span>
                    <span style="color: red">*</span>
                    <br>
                    <div class="input-group">
                        <input type="text" name="major" class="form-control" placeholder="Major" aria-describedby="basic-addon2" required="required">
                    </div>
                    <br>
                    <span>学号：</span>
                    <span style="color: red">*</span>
                    <br>
                    <div class="input-group">
                        <input type="number" name="sid" class="form-control" placeholder="Student ID" aria-describedby="basic-addon3" required="required">
                    </div>
                    <br>
                    <span>性别：</span>
                    <span style="color: red">*</span>
                    <br>
                    <div class="input-group">
                        <input type="text" name="gender" class="form-control" placeholder="Gender" aria-describedby="basic-addon4" required="required">
                    </div>
                    <br>
                    <span>电话：</span>
                    <span style="color: red">*</span>
                    <br>
                    <div class="input-group">
                        <input type="number" name="phone" class="form-control" placeholder="Phone" aria-describedby="basic-addon5" required="required">
                    </div>
                    <br>
                    <span>邮箱：</span>
                    <span style="color: red">*</span>
                    <br>
                    <div class="input-group">
                        <input type="email" name="email" class="form-control" placeholder="Email" aria-describedby="basic-addon6" required="required">
                    </div>
                    <br>
                    <div class="input-group">
                        <input type="submit" value="确定" class="form-control" placeholder="Submit" aria-describedby="basic-addon7" required="required">
                        <br>
                        <span>以上内容均需填写</span>
                    </div>
                    <br>
                </form>
            </div>
        </div>

    </div>
</div>

<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp"%>