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
        <jsp:param name="menu" value="ticket_lose"/>
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
                     <label>年票挂失</label>

                    <a class="btn btn-success btn-xs col-xs-offset-11" href="/sale/ticket/lose"> 返回上一级</a>

                 </div>
                 <div class="box-body">
                    <table class="table">
                        <tbody>
                        <tr>
                            <td class="text-muted">年票号：</td>
                            <td class="">${ticekt.ticketNum}</td>

                            <td class=" text-muted">状态：</td>
                            <td class="">${ticekt.ticketState}</td>

                        </tr>
                        <tr>
                            <td class="  text-muted">顾客信息：</td>
                            <td class="">${ticekt.customerId}</td>
                            <td class=" text-muted">生效时间：</td>
                            <td class=""><fmt:formatDate value="${ticekt.createTime}"/></td>
                        </tr>

                        </tbody>
                    </table>
                </div>
                 <div class="box-footer">

                     <a class="btn btn-warning btn-xs col-xs-offset-11 lose" href="javascript:;" rel="${ticekt.id}"><i class="fa fa-edit"></i>挂失</a>
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