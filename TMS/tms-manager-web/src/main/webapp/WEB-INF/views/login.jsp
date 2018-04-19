<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>TMS-综合管理系统</title>
    <%@include file="include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/iCheck/all.css">
    <link href="/static/dist/js/login.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="login_box">
    <div class="login_l_img"><img src="/static/dist/img/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="/static/dist/img/login_logo.png" /></a></div>
            <h3 class="login_name">TMS综合管理系统</h3>
            <c:if test="${not empty message}">
                <p class="login-box-msg text-danger">${message}</p>
            </c:if>
        <form method="post">
            <input name="username" type="text"  value="手机号" onfocus="this.value=''" onblur="if(this.value==''){this.value='手机号'}">
            <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
            <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
            <div class="checkbox">
                <label>
                    <input type="checkbox" class="checkbox" name="remember" value="remember"> 记住帐号
                </label>
            </div>
            <input value="登录" style="width:100%;" type="submit">
        </form>
    </div>
    <div class="copyright"></div>
</div>
<%@include file="include/js.jsp"%>
<script>

</script>
</body>
</html>
