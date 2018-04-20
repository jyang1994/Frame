<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 财务管理 - 入票管理</title>
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhed.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="ticket_in"/>
    </jsp:include>
    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                入票管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">入票记录列表</h3>

                        <div class="box-tools">
                            <a href="/finance/ticket/in/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增入票记录</a>
                        </div>

                </div>
                <div class="box-body">

                        <table class="table tree">
                            <thead>
                            <tr>
                                <th>入票时间</th>
                                <th>起始票号</th>
                                <th>结束票号</th>
                                <th>年票数量</th>
                                <th>入库负责人</th>
                                <th>#操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${ticketInLogs}" var="ticketInlog">
                                <tr>

                                    <td><fmt:formatDate value="${ticketInlog.createTime}"></fmt:formatDate></td>
                                    <td>${ticketInlog.startNum}</td>
                                    <td>${ticketInlog.endNum}</td>
                                    <td>${ticketInlog.totalNum}</td>
                                    <td>${ticketInlog.accountName}</td>
                                    <td>
                                             <a class="btn btn-primary btn-xs" href="/finance/ticket/${ticketInlog.id}/edit" title="修改"><i class="fa fa-pencil"></i></a>


                                            <a class="btn btn-danger btn-xs delLink" rel="${ticketInlog.id}" href="javascript:;" title="删除"><i class="fa fa-trash"></i></a>

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
<script>
    $(function () {
        $('.tree').treegrid();
        $(".delLink").click(function () {
            var id = $(this).attr("rel");
            console.log(id)
            layer.confirm("确定要删除吗？",function (index) {
                layer.close(index);
                $.get("/finance/ticket/" + id + "/del").done(function (result) {

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