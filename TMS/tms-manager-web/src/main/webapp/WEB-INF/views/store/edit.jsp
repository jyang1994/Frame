<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 修改售票点信息</title>
    <%@include file="../include/css.jsp" %>

</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/navhed.jsp" %>

    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="manage_store"/>
    </jsp:include>

    <!-- =============================================== -->

    <!-- 右侧内容部分 -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                售票点修改
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">修改售票点信息</h3>
                    <c:if test="${not empty message}">
                        <div style="color:#f44">${message}</div>
                    </c:if>
                    <div class="box-tools">
                        <a href="/store/home" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <div class="form-group ">
                            <label>法人姓名</label>
                            <input type="text" name="managerName" value="${storeSticket.managerName}" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="control-label">法人手机号</label>
                            <input type="text" value="${storeSticket.managerMobile}" name="managerMobile" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>售票点名称</label>
                            <input type="text" name="storeName" value="${storeSticket.storeName}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>售票点地址</label>
                            <input type="text" name="ticketStoreAddress" value="${storeSticket.ticketStoreAddress}" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>法人身份证号</label>
                            <input type="text" name="managerCard" value="${storeSticket.managerCard}" class="form-control">
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

<%@include file="../include/js.jsp" %>


<script>
    $(function () {
        // $(".check").change()


        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });



    })
</script>
</body>
</html>