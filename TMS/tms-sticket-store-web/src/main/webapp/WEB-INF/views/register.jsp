<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 售票点 - 注册认证</title>
    <%@include file="include/css.jsp" %>
</head>
<body>
<div class="container">


    <div class="panel panel-info">
        <div class="panel-heading"><h4 class="">售票点信息登记</h4></div>
        <div class="panel-body">
            <form class="form-horizontal" method="post">


                <div class="form-group ">
                    <label class="col-sm-2 control-label">法人姓名</label>
                    <div class="col-sm-8">
                        <input type="text" name="permissionName" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">法人手机号</label>
                        <div class="col-sm-8">
                            <input type="text" name="permissionName" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">售票点名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="permissionName" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">售票点地址</label>
                        <div class="col-sm-8">
                            <input type="text" name="permissionName" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">营业执照照片</label>
                        <div class="col-sm-8">
                            <input type="text" name="permissionName" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">法人身份证号</label>
                        <div class="col-sm-8">
                            <input type="text" name="permissionName" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">身份证正面</label>
                        <div class="col-sm-8">
                            <input type="text" name="permissionName" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">身份证反面</label>
                        <div class="col-sm-8">
                            <input type="text" name="permissionName" class="form-control">
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>


    <%@include file="include/js.jsp" %>
    <script>
        $(function () {
            $("#saveBtn").click(function () {
                $("#saveForm").submit();
            });
        })
    </script>
</body>
</html>