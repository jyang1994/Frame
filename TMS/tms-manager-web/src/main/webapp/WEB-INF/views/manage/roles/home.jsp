<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 角色管理</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhed.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="roles_permission"/>
    </jsp:include>
    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                角色管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">角色列表</h3>
                    <shiro:hasPermission name="roles:add">
                        <div class="box-tools">
                            <a href="/manage/roles/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增角色</a>
                        </div>
                    </shiro:hasPermission>
                </div>
                <div class="box-body">
                    <table class="table tree">

                        <tbody>
                        <c:forEach items="${rolesList}" var="roles">
                            <tr class="success">
                                <td>
                                    角色名称：<strong>${roles.roleName}</strong>
                                    <shiro:hasPermission name="roles:edit">
                                     <a class="btn btn-primary btn-xs " href="/manage/roles/${roles.id}/edit" title="修改"><i class="fa fa-pencil"></i></a>
                                    </shiro:hasPermission>
                                    <shiro:hasPermission name="roles:del">
                                    <a class="btn btn-danger btn-xs delLink" rel="${roles.id}" href="javascript:;" title="删除"><i class="fa fa-trash"></i></a>
                                    </shiro:hasPermission>
                                </td>

                            </tr>
                            <tr>
                                <td>
                                    <c:forEach items="${roles.rolesPermissionKeyList}" var="currRolesPermission">
                                       <c:forEach items="${currRolesPermission.permissionList}" var="currPermission">
                                           <i class="fa fa-circle"></i>${currPermission.permissionName}
                                       </c:forEach>
                                    </c:forEach>

                                </td>
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
    $(function () {
        $('.tree').treegrid();
        $(".delLink").click(function () {
            var id = $(this).attr("rel");
            layer.confirm("确定要删除吗？",function (index) {
                layer.close(index);
                $.get("/manage/roles/" + id + "/del").done(function (result) {

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
        })
    });
</script>
</body>
</html>
</html>