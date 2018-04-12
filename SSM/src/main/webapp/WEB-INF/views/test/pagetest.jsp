<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
    <title></title>
</head>
<body>
    <h3>wo</h3>
    <ul id="pagination-demo" class="pagination pull-right"></ul>
    <script src="/static/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="/static/bootstrap/js/bootstrap.js"></script>
    <script src="/static/plugins/jQuery/jquery.twbsPagination.min.js"></script>
    <script>
        $(function(){
            $("#pagination-demo").twbsPagination({
                totalPages: 20,
                visiblePages: 10,
                first:"首页",
                last:"末页",
                prev:"上一页",
                next:"下一页",
                href:"?p={{number}}"
            });
        })
     </script>
</body>
</html>