<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 财务管理 - 入票管理</title>
    <%@include file="../../include/css.jsp" %>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../../include/navhed.jsp" %>

    <!-- =============================================== -->

    <jsp:include page="../../include/sider.jsp">
        <jsp:param name="menu" value="ticket_in"/>
    </jsp:include>
    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
      <%--  <section class="content-header">
            <h1>
                入票管理
            </h1>
        </section>--%>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">年票列表</h3>

                    <div class="box-tools">

                        <a href="/finance/ticket/in/home" class="btn btn-success btn-sm"><i class="fa fa-eye"></i> 返回</a>

                    </div>


                </div>
                <div class="box-body">

                    <table class="table tree">
                        <thead>
                        <tr>
                            <th>票号</th>
                            <th>入库时间</th>
                            <th>出库时间</th>
                            <th>购买人</th>
                            <th>售票点</th>
                            <th>状态</th>
                            <td>#操作</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ticketPageInfo.list}" var="ticket">
                            <tr>
                                <td>${ticket.ticketNum}</td>
                                <td><fmt:formatDate value="${ticket.ticketInTime}"></fmt:formatDate></td>
                                <td><fmt:formatDate value="${ticket.ticketOutTime}"></fmt:formatDate></td>
                                <td>${ticket.customerId}</td>
                                <td>${ticket.storeSticket.storeName}</td>
                                <td>${ticket.ticketState}</td>


                                <td>

                                        <a class="btn btn-primary btn-xs" href="/finance/ticket/${ticketInlog.id}/edit"
                                           title="修改"><i class="fa fa-pencil"></i></a>


                                        <a class="btn btn-danger btn-xs delLink" rel="${ticketInlog.id}"
                                           href="javascript:;" title="删除"><i class="fa fa-trash"></i></a>
                                </td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                    <ul id="pagination" class="pagination pull-right"></ul>

                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp" %>
<script>
    $(function () {
        $("#pagination").twbsPagination({
            totalPages: ${ticketPageInfo.pages},
            visiblePages: 5,
            first:"首页",
            last:"末页",
            prev:"上一页",
            next:"下一页",
            href:"?p={{number}}"
        });
        $('.tree').treegrid();
        $(".delLink").click(function () {
            var id = $(this).attr("rel");
            console.log(id)
            layer.confirm("确定要删除吗？", function (index) {
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