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

            <div class="col-sm-5">
                <div class="panel panel-default"><!--右侧的列表 -->
                    <div class="panel-heading">
                        <h3 class="panel-title">个人信息</h3>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">用户名：</label>
                                <label  class="col-sm-2 control-label">${sessionScope.user.username}</label>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">真实姓名：</label>
                                <label  class="col-sm-2 control-label">${sessionScope.user.realname}</label>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">专业：</label>
                                <label  class="col-sm-2 control-label">${sessionScope.user.major.major}</label>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">学号：</label>
                                <label  class="col-sm-2 control-label">${sessionScope.user.sid}</label>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">性别：</label>
                                <label  class="col-sm-2 control-label">${sessionScope.user.gender}</label>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">电话：</label>
                                <label  class="col-sm-2 control-label">${sessionScope.user.phone}</label>
                            </div>
                            <div class="form-group">
                                <label  class="col-sm-2 control-label">邮箱：</label>
                                <label  class="col-sm-2 control-label">${sessionScope.user.email}</label>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-sm-5">
            <div class="panel panel-default"><!--右侧的列表 -->
                <div class="panel-heading">
                    <h3 class="panel-title">修改信息</h3>
                </div>
                <div class="panel-body">
                    <form action="${pageContext.request.contextPath}/datailChange.action" method="post">
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
                            <input type="reset" value="重置" class="form-control" placeholder="Submit" aria-describedby="basic-addon7" required="required">
                        </div>
                        <br>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<%--  获取公共尾部--%>
<%@ include file="iframe/foot.jsp" %>

