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
        <jsp:param name="menu" value="ticket_pay"/>
    </jsp:include>
    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年票下发管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">年票下发列表</h3>

                </div>
                <div class="box-body">

                    <table class="table tree">
                        <thead>
                        <tr>
                            <th>负责人</th>
                            <th>下发时间</th>
                            <th>下发点</th>
                            <th>起始票号</th>
                            <th>截止票号</th>
                            <th>总数量</th>
                            <th>单价</th>
                            <th>总价</th>
                            <th>状态</th>
                            <th>#操作</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ticketOutList}" var="ticketOut">
                            <tr>
                                <td>${ticketOut.outAccount}</td>
                                <td><fmt:formatDate value="${ticketOut.outTime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></td>
                                <td>${ticketOut.outStore}</td>
                                <td>${ticketOut.outStartTicket}</td>
                                <td>${ticketOut.outEndTicket}</td>
                                <td>${ticketOut.outNum}</td>
                                <td>${ticketOut.onePrice}</td>
                                <td>${ticketOut.totalPrice}</td>
                                <td>
                                    <button class="btn btn-xs ${ticketOut.outState == '未支付'?'btn-danger':'btn-success'}" >${ticketOut.outState}</button>
                                </td>
                                <td>
                                    <c:if test="${ticketOut.outState == '未支付'}">
                                    <a class="btn btn-warning btn-xs pay" rel="${ticketOut.id}"
                                       href="javascript:;" title="确认支付">确认支付</a>
                                    </c:if>
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

<%@include file="../../include/js.jsp" %>
<script>
    $(function () {
        $('.tree').treegrid();
        $(".pay").click(function () {
            var id = $(this).attr("rel");
            console.log(id)
            layer.confirm("确定支付吗？", function (index) {
                layer.close(index);
                $.get("/finance/ticket/out/" + id + "/pay").done(function (result) {

                    if (result.status == "success") {
                        layer.msg("支付成功")
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