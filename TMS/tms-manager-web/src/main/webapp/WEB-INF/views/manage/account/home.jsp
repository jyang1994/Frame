<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
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

            <div class="box no-border">
                <div class="box-body">
                    <form class="form-inline">
                        <input type="text" name="username" placeholder="账号" class="form-control" value="${param.username}">
                        <select name="rolesId" class="form-control">
                            <option value="">所有账号</option>
                            <c:forEach items="${rolesList}" var="roles">
                                <option value="${roles.id}" ${param.rolesId == roles.id ? 'selected' : ''}>${roles.roleName}</option>
                            </c:forEach>
                        </select>
                        <button class="btn btn-default">搜索</button>
                    </form>
                </div>
            </div>

            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">帐号列表</h3>
                    <shiro:hasPermission name="account:add">
                    <div class="box-tools">
                        <a href="/manage/account/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增帐号</a>
                    </div>
                    </shiro:hasPermission>
                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>手机号码</th>
                            <th>锁定状态</th>
                            <th>禁用状态</th>
                            <th>角色类型</th>
                            <th>操作#</th>
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
                                <td>
                                    <shiro:hasPermission name="account:edit">
                                         <a class="btn btn-primary btn-xs" href="/manage/account/${account.id}/edit" title="修改"><i class="fa fa-pencil"></i></a>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="account:del">
                                     <a class="btn btn-danger btn-xs delLink" rel="${account.id}" href="javascript:;" title="删除"><i class="fa fa-trash"></i></a>
                                    </shiro:hasPermission>
                                </td>

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
<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(".delLink").click(function () {
        var id = $(this).attr("rel");
        var loginId ="<shiro:principal property='id'/>";
        if(id == loginId){
            layer.msg("不能删除当前登陆账号！");
        }else{
            layer.confirm("确定要删除吗？",function (index) {
                layer.close(index);
                $.get("/manage/account/" + id + "/del").done(function (result) {

                    if (result.status == "success") {
                        layer.msg("删除成功")
                        history.go(0);
                    } else {
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器忙！")
                })

             })
        }
    })
</script>
</body>
</html>
</html>