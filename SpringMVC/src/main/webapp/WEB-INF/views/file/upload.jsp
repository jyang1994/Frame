<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title></title>
</head>
<body>
    <c:if test="${not empty message}">
        <h3 style="color: red">${message}</h3>
    </c:if>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="name"><br>
        <input type="file" name="photo"><br>
        <button>上传</button>
    </form>

</body>
</html>