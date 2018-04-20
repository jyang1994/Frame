<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS - 系统管理 - 帐号管理</title>
    <%@include file="../include/css.jsp"%>

</head>
<body class="hold-transition skin-purple sidebar-mini">
<!-- Site wrapper -->
<div class="wrapper">

    <%@include file="../include/navhed.jsp"%>

    <!-- =============================================== -->

    <jsp:include page="../include/sider.jsp">
        <jsp:param name="menu" value="store_home"/>
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
                <div class="box-body">
                    <form method="get" class="form-inline">
                        <input type="text" name="name" class="form-control" placeholder="联系人姓名" value="${param.storeManager}">
                        <input type="text" name="mobile" class="form-control" placeholder="联系电话" value="${param.storeTel}">
                        <input type="text" name="storename" class="form-control" placeholder="售票点名称" value="${param.storeName}">
                        <input type="text" name="address" class="form-control" placeholder="售票点地址" value="${param.storeName}">
                        <button class="btn btn-default">搜索</button>
                    </form>
                </div>
            </div>

            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">售票点列表</h3>

                        <div class="box-tools">
                            <a href="/store/new" class="btn btn-success btn-sm"><i class="fa fa-plus"></i> 新增售票点</a>
                        </div>

                </div>
                <div class="box-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>法人姓名</th>
                            <th>联系方式</th>
                            <th>售票点名称</th>
                            <th>售票点地址</th>
                            <th>#操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${sticketPageInfo.list}" var="storeSticket">
                            <tr >

                                <td>${storeSticket.managerName}</td>
                                <td>${storeSticket.managerMobile}</td>
                                <td>${storeSticket.storeName}</td>
                                <td>${storeSticket.ticketStoreAddress}</td>
                                <td>
                                        <a class="btn btn-primary btn-xs" href="/store/${storeSticket.id}/edit" title="修改"><i class="fa fa-pencil"></i></a>


                                        <a class="btn btn-danger btn-xs delLink" rel="${storeSticket.id}" href="javascript:;" title="删除"><i class="fa fa-trash"></i></a>

                                </td>

                            </tr>

                        </c:forEach>

                        </tbody>

                    </table>
                    <ul id="pagination" class="pagination pull-right"></ul>
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

        $("#pagination").twbsPagination({
            totalPages: ${sticketPageInfo.pages},
            visiblePages: 5,
            first:"首页",
            last:"末页",
            prev:"上一页",
            next:"下一页",
            href:"?p={{number}}"
        });

        $(".delLink").click(function () {

            var id = $(this).attr("rel");

            layer.confirm("确定要删除吗？", function (index) {
                layer.close(index);
                $.get("/store/" + id + "/del").done(function (result) {
                    console.log(result.status);
                    if (result.status == "success") {
                        layer.msg("删除成功")
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