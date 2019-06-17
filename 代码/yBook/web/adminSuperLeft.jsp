<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/06/11
  Time: 16:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-sm-2">
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                       aria-expanded="true" aria-controls="collapseOne">
                        管理员管理
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                <div class="list-group">
                    <a href="adminSuperAdminAdd.jsp" class="list-group-item">新增普通管理员</a>
                    <a href="adminsuperadminlist.action" class="list-group-item">普通管理员管理</a>
                </div>
            </div>
        </div>

    </div>
</div>