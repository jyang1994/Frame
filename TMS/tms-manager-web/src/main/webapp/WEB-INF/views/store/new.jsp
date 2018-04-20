<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 新增角色</title>
    <%@include file="../include/css.jsp" %>
    <style>
        .photo {
            width: 100%;
            height: 300px;
            border: 2px dashed #ccc;
            margin-top: 20px;
            text-align: center;
            line-height: 300px;
        }
    </style>
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
                售票点管理
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
                        <a href="/store/home" class="btn btn-success btn-sm">返回</a>
                    </div>
                </div>
                <div class="box-body">
                    <form method="post" id="saveForm">
                        <div class="form-group ">
                            <label>法人姓名</label>
                            <input type="text" name="managerName" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="control-label">法人手机号</label>
                            <input type="text" name="managerMobile" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>售票点名称</label>
                            <input type="text" name="storeName" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>售票点地址</label>
                            <input type="text" name="ticketStoreAddress" class="form-control">
                        </div>

                        <div class="form-group">
                            <label>法人身份证号</label>
                            <input type="text" name="managerCard" class="form-control">
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div id="picker">添加负责人身份证照片</div>
                                <div class="photo" id="userPhoto"></div>
                            </div>
                            <div class="col-md-6">
                                <div id="picker2">添加营业执照照片</div>
                                <div class="photo" id="storePhoto"></div>
                            </div>
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

        //初始化webuploader
        var uploader = WebUploader.create({
            auto: true,
            swf: '/static/plugins/uploader/Uploader.swf',
            //tms-1252494188.cos.ap-beijing.myqcloud.com腾讯云
            server: 'http://upload-z2.qiniup.com',
            fileVal: 'file',
            pick: '#picker',
            formData:{
                "token":"${upToken}"
            },
             accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/!*'
            }
        });
        var index = -1;
        uploader.on('uploadStart', function (file) {
            index = layer.load(1);
        });
        uploader.on('uploadSuccess', function (file, response) {
            $("#userPhoto").html("");
            var fileName = response.key;
            var $img = $("<img>").attr("src", "http://p7f6tjc1h.bkt.clouddn.com/" + fileName + "-preview");
            $img.appendTo($("#userPhoto"));
            //将key存放到隐藏域中
            $("#storeManagerAttachment").val(fileName);
            layer.msg("上传成功");
        });
        uploader.on('uploadError', function (file) {
            layer.msg("服务器异常");
        });
        uploader.on('uploadComplete', function (file) {
            layer.close(index);
        });


        var uploader2 = WebUploader.create({
            auto: true,
            swf: '/static/plugins/uploader/Uploader.swf',
            //tms-1252494188.cos.ap-beijing.myqcloud.com腾讯云
            server: 'http://upload-z2.qiniup.com',
            fileVal: 'file',
            pick: '#picker2',
            formData:{
                "token":"${upToken}"
            },
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/!*'
            }
        });
        var index = -1;
        uploader2.on('uploadStart', function (file) {
            index = layer.load(1);
        });
        uploader2.on('uploadSuccess', function (file, response) {
            $("#userPhoto").html("");
            var fileName = response.key;
            var $img = $("<img>").attr("src", "http://p7hlny1f4.bkt.clouddn.com/" + fileName + "-jyang");
            $img.appendTo($("#userPhoto"));
            //将key存放到隐藏域中
            $("#storeManagerAttachment").val(fileName);
            layer.msg("上传成功");
        });
        uploader2.on('uploadError', function (file) {
            layer.msg("服务器异常");
        });
        uploader2.on('uploadComplete', function (file) {
            layer.close(index);
        });

    })
</script>
</body>
</html>