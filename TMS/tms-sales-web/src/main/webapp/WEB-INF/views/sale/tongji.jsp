<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 销售系统</title>
    <%@include file="../include/css.jsp"%>

</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/navhed.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="sale_tongji"/>
    </jsp:include>
    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                年票详情
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h4>年票挂失</h4>

                    <a class="btn btn-success btn-xs col-xs-offset-11" href="/sale/ticket/lose"> 返回上一级</a>

                </div>
                <div class="box-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <td class="text-muted">总计：</td>
                            <td class="">${ticekt.ticketNum}</td>

                            <td class=" text-muted">库存：</td>
                            <td class="">${ticekt.ticketState}</td>

                            <td class="  text-muted">销售：</td>
                            <td class="">${ticekt.customerId}</td>
                            <td class=" text-muted">挂失：</td>
                            <td class=""><fmt:formatDate value="${ticekt.createTime}"/></td>
                        </tr>

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

<%@include file="../include/js.jsp"%>


<script src="/static/plugins/layer/layer.js"></script>
<script>
    $(function(){


        $(".lose").click(function () {

            var id = $(this).attr("rel");
            console.log(id);
            layer.confirm("确定挂失吗？", function (index) {
                layer.close(index);
                $.get("/sale/" + id + "/lose").done(function (result) {
                    console.log(result.status);
                    if (result.status == "success") {
                        layer.msg("挂失成功")
                        history.go(0);
                    } else {
                        layer.msg(result.message);
                    }
                }).error(function () {
                    layer.msg("服务器忙！")
                })

            })
        })
    })



</script>
</body>
</html>
</html>