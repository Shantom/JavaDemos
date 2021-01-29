<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ningwei.shi
  Date: 2021/1/28
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/book/addBook" method="post">
    <label>名称：
        <input type="text" name="bookName" required>
    </label>
    <label>数量：
        <input type="text" name="bookCounts" required>
    </label>
    <label>详情：
        <input type="text" name="detail" required>
    </label>
    <input type="submit" value="添加">
</form>

<h1></h1>

</body>
</html>
