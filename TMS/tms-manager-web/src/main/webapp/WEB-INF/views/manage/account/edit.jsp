<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 新增帐号</title>
    <%@include file="../../include/css.jsp"%>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhed.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value=" account_roles"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                修改帐号
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">修改帐号</h3>
                    <div class="box-tools">
                        <a href="/manage/account/home" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <div class="form-group">
                            <label>手机号码</label>
                            <input type="text" value="${acc.username}" name="username" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>账号密码</label>
                            <input type="password" value="${acc.password}" name="password" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>锁定状态</label>
                            <select name="accLock"  class="form-control">

                            <option value="1">正常</option>
                                <option value="0">锁定</option>

                            </select>
                        </div>
                        <div class="form-group">
                            <label>禁用状态</label>
                            <select name="disable" class="form-control">

                                <option value="1">正常</option>
                                <option value="0">禁用</option>

                            </select>
                        </div>
                        <div class="form-group">
                            <label>角色类型</label>
                            <select name="rolesId" class="form-control">
                                <c:forEach items="${rolesList}" var="roles">
                                    <option value="${roles.id}">${roles.roleName}</option>
                                </c:forEach>

                            </select>
                        </div>
                    </form>
                </div>
                <div class="box-footer">
                    <button class="btn pull-right btn-primary" id="saveBtn">保存</button>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>
<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
    })
</script>
</body>
</html>