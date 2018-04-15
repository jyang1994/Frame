<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 帐号管理</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhed.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="account_roles"/>
    </jsp:include>
    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                帐号管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">帐号列表</h3>
                    <div class="box-tools">
                        <a href="/manage/account/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增帐号</a>
                    </div>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>手机号码</th>
                            <th>锁定状态</th>
                            <th>禁用状态</th>
                            <th>角色类型</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${accountList}" var="account">
                            <tr >

                                <td>${account.username}</td>
                                <td>${account.accLock == 1 ? "正常":"锁定"}</td>
                                <td>${account.disable == 1 ? "正常":"禁用"}</td>
                                <td><c:forEach items="${account.accountRolesKeysList}" var="accountRoles">
                                    <c:forEach items="${accountRoles.rolesList}" var="roles" >
                                        ${roles.roleName}
                                    </c:forEach>
                                </c:forEach>

                                </td>
                                <td><a href="/manage/account/${account.id}/edit">修改</a> <a href="/manage/account/${account.id}/del">删除</a></td>

                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>
<script src="/static/plugins/treegrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<script>

</script>
</body>
</html>
</html>