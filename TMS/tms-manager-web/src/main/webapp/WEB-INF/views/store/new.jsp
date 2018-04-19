<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 新增角色</title>
    <%@include file="../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
    <!-- iCheck -->
    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">
</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/navhed.jsp"%>

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
                角色管理
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">新增售票点信息</h3>
                    <c:if test="${not empty message}">
                        <div style="color:#f44">${message}</div>
                    </c:if>
                    <div class="box-tools">
                        <a href="/manage/roles/home" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form class="form-horizontal"  enctype="multipart/form-data" method="post" id="saveForm">


                        <div class="form-group ">
                            <label class="col-sm-2 control-label">法人姓名</label>
                            <div class="col-sm-8">
                                <input type="text" name="managerName" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">法人手机号</label>
                            <div class="col-sm-8">
                                <input type="text" name="managerMobile" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">售票点名称</label>
                            <div class="col-sm-8">
                                <input type="text" name="storeName" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">售票点地址</label>
                            <div class="col-sm-8">
                                <input type="text" name="ticketStoreAddress" class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">法人身份证号</label>
                            <div class="col-sm-8">
                                <input type="text" name="managerCard"  class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">营业执照照片</label>
                            <div class="col-sm-8">
                                <input type="file" name="businessPhoto" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">身份证正面</label>
                            <div class="col-sm-8">
                                <input type="file" name="cardBefore" class="form-control">
                            </div>
                        </div>
                     </form>
                </div>
                <div class="box-footer">
                    <button class="btn pull-right btn-primary"  id="saveBtn">保存</button>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->

<%@include file="../include/js.jsp"%>
<script src="/static/plugins/treegrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<!-- iCheck -->
<script src="/static/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function () {
        // $(".check").change()


        $("#saveBtn").click(function () {
            $("#saveForm").submit();
        });
        $('.tree').treegrid();
        // $('input[type=checkbox]').iCheck({
        //     checkboxClass: 'icheckbox_square-blue',
        //     radioClass: 'iradio_square-blue',
        //     increaseArea: '20%', /!* optional *!/
        //
        // });


        $(".check").change(function () {
            var currId = $(this).val();

            var str = ".treegrid-parent-" + currId;

            if ($(this).is(":checked")) {
                $(str).find("input").prop("checked", true);
            }else {
                $(str).find("input").prop("checked", false);
            }
        })


    })
</script>
</body>
</html>