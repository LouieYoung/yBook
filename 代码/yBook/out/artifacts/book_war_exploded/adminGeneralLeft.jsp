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
                        用户管理
                    </a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                <div class="list-group">
                    <a href="admingeneralusermanage.action" class="list-group-item">用户信息管理</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        书籍管理
                    </a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="list-group">
                    <a href="adminGeneralBooktypeAdd.jsp" class="list-group-item">新增书籍分类</a>
                    <a href="admingeneralbooktypemanage.action" class="list-group-item">书籍分类管理</a>
                    <a href="admingeneralbookmanage.action" class="list-group-item">书籍信息管理</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        公告管理
                    </a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel"
                 aria-labelledby="headingThree">
                <div class="list-group">
                    <a href="adminGeneralAfficheAdd.jsp" class="list-group-item">新增公告信息</a>
                    <a href="admingeneralaffichelist.action" class="list-group-item">公告信息管理</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingFour">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        留言板管理
                    </a>
                </h4>
            </div>
            <div id="collapseFour" class="panel-collapse collapse" role="tabpanel"
                 aria-labelledby="headingFour">
                <div class="list-group">
                    <a href="adminguestbooklist.action" class="list-group-item">留言板信息管理</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingFive">
                <h4 class="panel-title">
                    <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                       href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                        订单管理
                    </a>
                </h4>
            </div>
            <div id="collapseFive" class="panel-collapse collapse" role="tabpanel"
                 aria-labelledby="headingFive">
                <div class="list-group">
                    <a href="adminorderlist.action" class="list-group-item">历史订单展示</a>
                </div>
            </div>
        </div>
    </div>
</div>