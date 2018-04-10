<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <title></title>
</head>
<body>
    <div class="container">
        <h3>商品列表</h3>
        <c:if test="${not empty message}">
            <div class="alert alert-success">${message}</div>
        </c:if>
        <a href="/product/new" class="btn btn-primary pull-right">添加商品</a>
        <table class="table">
            <thead>
                <tr>
                    <th>商品名称</th>
                    <th>价格</th>
                    <th>市场价</th>
                    <th>产地</th>
                    <th>所属分类</th>
                    <th>#</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productPageInfo.list}" var="product">

                    <tr>
                        <th><a href="/product/${product.id}">${product.productName}</th>
                        <td>${product.price}</td>
                        <td>${product.marketPrice}</td>
                        <td>${product.place}</td>
                        <td>${product.productType.typeName}</td>
                        <td>
                            <a href="/product/${product.id}/edit">编辑</a>
                            <a href="javascript:;" class="delLink" rel="${product.id}">删除</a>
                        </td>
                    </tr>

                </c:forEach>
            </tbody>

        </table>
        <ul id="pagination-demo" class="pagination pull-right"></ul>
    </div>
    <script src="/static/js/jquery.min.js"></script>
    <script src="/static/js/bootstrap.js"></script>
    <script src="/static/js/jquery.twbsPagination.js"></script>
    <script>
        $(function(){

            $("#pagination-demo").twbsPagination({
                totalPages: ${productPageInfo.pages},
                visiblePages: 10,
                first:"首页",
                last:"末页",
                prev:"上一页",
                next:"下一页",
                href:"?p={{number}}"
            });
            $(".delLink").click(function () {
                var id = $(this).attr("rel");
                if(confirm("确定要删除吗")) {
                    window.location.href = "/product/"+id+"/del";
                }
            });
        })
    </script>
</html>