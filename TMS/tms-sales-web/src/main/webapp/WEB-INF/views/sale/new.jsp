<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 销售管理 - 年票销售</title>
    <%@include file="../include/css.jsp"%>
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/navhed.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="account_roles"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">

        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                办理销售登记
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">新增记录</h3>
                    <div class="box-tools">
                        <a href="/sale/ticket" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <div class="box">
                        <c:if test="${not empty message}">
                            <p class="danger" >${message}</p>
                        </c:if>
                    </div>
                    <%-- <c:if test="${not empty message}">
                         <p class="bg-danger">${message}</p>
                     </c:if>--%>
                    <form method="post" id="saveForm">

                        <div class="form-group">
                            <label>消费者姓名</label>
                            <input type="text" name="username" class="form-control" placeholder="请输入消费者姓名">
                        </div>
                        <div class="form-group">
                            <label>消费者手机号</label>
                            <input type="text" name="mobile" class="form-control" placeholder="请输入消费者手机号">
                        </div>
                        <div class="form-group">
                            <label>消费者地址</label>
                            <input type="text" name="address" class="form-control" placeholder="请输入消费者地址">
                        </div>
                        <div class="form-group">
                            <label>消费者证件号码</label>
                            <input type="text" name="cardNum" class="form-control" placeholder="请输入消费者证件">
                        </div>
                        <div class="form-group">
                            <label>票号</label>
                            <div>
                                <input class="form-control" name="saleTicketNum" placeholder="输入年票票号">
                            </div>
                        </div>

                        <div class="form-group">
                            <label>金额</label>
                            <input type="text"  name="salePrice" class="form-control" placeholder="请输入销售金额">
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

<%@include file="../include/js.jsp"%>
<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
        var res = "${message}"

        if(res != ""){
            layer.msg("!!!"+res);
        }
    })

</script>
</body>
</html>