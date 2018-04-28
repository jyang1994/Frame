<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 销售管理 - 年票销售</title>
    <%@include file="../include/css.jsp"%>
    <style>

        .photo {
            width: 100%;
            height: 250px;
            border: 2px dashed #ccc;
            margin-top: 20px;
            text-align: center;
            line-height: 250px;
        }
    </style>
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
                        <input type="hidden" name="cardBefore" id="cardBefore">
                        <input type="hidden" name="cardAfter" id="cardAfter">
                        <input type="hidden" name="personPhoto" id="personPhoto">
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
                        <div class="row">
                            <div class="col-md-4">
                                <div id="picker1">选择身份证正面照片</div>
                                <div class="photo" id="userCardPhoto"></div>
                            </div>
                            <div class="col-md-4">
                                <div id="picker2">选择身份证反面照片</div>
                                <div class="photo" id="userCardPhotoBack"></div>
                            </div>
                            <div class="col-md-4">
                                <div id="picker3">选择免冠照片</div>
                                <div class="photo" id="userPhoto"></div>
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

<%@include file="../include/js.jsp"%>
<script>
    $(function () {

        var uploader = WebUploader.create({
            // 选完文件后，是否自动上传。
            auto: true,
            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',
            // 文件接收服务端。
            server: '/file/upload',
            fileVal:'file',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker1',
            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        var index = -1;
        uploader.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });
        uploader.on( 'uploadSuccess', function( file,response ) {
            $("#userCardPhoto").html("");
            if(response.status == 'success') {
                var fileName = response.data;
                var $img = $("<img>").attr("src","/file/down?fileId="+fileName).attr("width","200");
                $img.appendTo($("#userCardPhoto"));
                //将key存放到隐藏域中
                $("#cardBefore").val(fileName);
                layer.msg("上传成功");
            } else {
                layer.msg(response.message);
            }
        });
        uploader.on( 'uploadError', function( file ) {
            layer.msg("服务器异常");
        });
        uploader.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });

        var uploader2 = WebUploader.create({
            // 选完文件后，是否自动上传。
            auto: true,
            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',
            // 文件接收服务端。
            server: '/file/upload',
            fileVal:'file',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker2',
            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        var index = -1;
        uploader2.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });
        uploader2.on( 'uploadSuccess', function( file,response ) {
            $("#userCardPhotoBack").html("");
            if(response.status == 'success') {
                var fileName = response.data;
                var $img = $("<img>").attr("src","/file/down?fileId="+fileName).attr("width","200");
                $img.appendTo($("#userCardPhotoBack"));
                //将key存放到隐藏域中
                $("#cardAfter").val(fileName);
                layer.msg("上传成功");
            } else {
                layer.msg(response.message);
            }
        });
        uploader2.on( 'uploadError', function( file ) {
            layer.msg("服务器异常");
        });
        uploader2.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });


        var uploader3 = WebUploader.create({
            // 选完文件后，是否自动上传。
            auto: true,
            // swf文件路径
            swf: '/static/plugins/uploader/Uploader.swf',
            // 文件接收服务端。
            server: '/file/upload',
            fileVal:'file',
            // 选择文件的按钮。可选。
            // 内部根据当前运行是创建，可能是input元素，也可能是flash.
            pick: '#picker3',
            // 只允许选择图片文件。
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            }
        });
        var index = -1;
        uploader3.on( 'uploadStart', function( file ) {
            index = layer.load(1);
        });
        uploader3.on( 'uploadSuccess', function( file,response ) {
            $("#userPhoto").html("");
            if(response.status == 'success') {
                var fileName = response.data;
                var $img = $("<img>").attr("src","/file/down?fileId="+fileName).attr("width","200");
                $img.appendTo($("#userPhoto"));
                //将key存放到隐藏域中
                $("#personPhoto").val(fileName);
                layer.msg("上传成功");
            } else {
                layer.msg(response.message);
            }
        });
        uploader3.on( 'uploadError', function( file ) {
            layer.msg("服务器异常");
        });
        uploader3.on( 'uploadComplete', function( file ) {
            layer.close(index);
        });


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