<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/7
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>

    <footer class="footer" style="background:#dcdfe1;color:#FFFFFF">
        <div class="container">
            <h3>Contact</h3>
            <h2>LouieYoung@Foxmail.com</h2>

            <div class=jstime style="float: right;width: 45%;text-align:right;color: #0f0f0f;">
                <!--****************时间日历开始****************-->
                <script>
                    setInterval("clock.innerHTML=new Date().toLocaleString()+'&nbsp;&nbsp;星期'+'日一二三四五六'.charAt(new Date().getDay());",1000)
                </script>
                <span id=clock></span>
                <!--****************时间日历结束****************-->&nbsp;&nbsp;
            </div>
        </div>

    </footer>
    <footer class="footer" style="background:#c3c5cb;color:#F6F6F6">
        <div class="container">
            <h5>© 2019 Hentai Intelligent Tadpole. All Rights Reserved</h5>
        </div>
    </footer>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>