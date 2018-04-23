<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 结算管理 - 新增下发</title>
    <%@include file="../../include/css.jsp"%>
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
                添加下发记录
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">新增年票下发</h3>
                    <div class="box-tools">
                        <a href="/manage/account/home" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <%-- <c:if test="${not empty message}">
                         <p class="bg-danger">${message}</p>
                     </c:if>--%>
                    <form method="post" id="saveForm">
                        <div class="form-group">
                            <label>下发票点</label>
                            <div>
                                <select name="outStore" id="outStore">
                                    <c:forEach items="${storeSticketList}" var="storeSticket">
                                        <option value="${storeSticket.storeName}">${storeSticket.storeName}</option>
                                    </c:forEach>

                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label>起始票号</label>
                            <input type="text" name="outStartTicket" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>结束票号</label>
                            <input type="text"  name="outEndTicket" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>单价</label>
                            <input type="text" name="onePrice" class="form-control">
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

<%@include file="../../include/js.jsp"%>
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