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
        <jsp:param name="menu" value="ticket_invalid"/>
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
        <section class="content-header">
            <h2>年票列表</h2>
        </section>
        <section class="content">
            <div class="box">

                <div class="box-body">
                    <form class="form-inline">
                        <input class="form-control" type="text" name="ticketNum" placeholder="请输入票号">
                        <button class="btn btn-default">搜索</button>
                    </form>
                </div>
            </div>
            <div class="box">
                <div class="box-body">

                    <table class="table tree">
                        <thead>
                        <tr>
                            <th>票号</th>
                            <th>入库时间</th>
                            <th>出库时间</th>
                            <th>购买者</th>

                            <th>状态</th>
                            <td>&emsp;#操作</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${ticketPageInfo.list}" var="ticket">
                            <tr>
                                <td>${ticket.ticketNum}</td>
                                <td><fmt:formatDate value="${ticket.ticketInTime}"></fmt:formatDate></td>
                                <td><fmt:formatDate value="${ticket.ticketOutTime}"></fmt:formatDate></td>
                                <td>${ticket.customerId}</td>

                                    <td ><span class="btn ${ticket.ticketState == '作废'?'btn-danger':'btn-primary'} btn-xs">${ticket.ticketState}</span></td>

                                <td>

                                    <a href="/finance/ticket/${ticket.id}/edit"
                                       title="修改">修改 </a>


                                    <a class="delLink" rel="${ticket.id}"
                                       href="javascript:;" title="作废"> </i>作废</a>
                                </td>
                            </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                    <c:if test="${ticketPageInfo.pages != 1}">
                    <ul id="pagination" class="pagination pull-right"></ul>
                    </c:if>
                </div>
            </div>
        </section>
    </div>

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
            first: "首页",
            last: "末页",
            prev: "上一页",
            next: "下一页",
            href: "?p={{number}}"
        });
        $('.tree').treegrid();
        $(".delLink").click(function () {
            var id = $(this).attr("rel");
            console.log(id)
            layer.confirm("确定要作废吗？", function (index) {
                layer.close(index);
                $.get("/finance/ticket/" + id + "/invalid").done(function (result) {

                    if (result.status == "success") {
                        layer.msg("年票已作废")
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