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
    <title>修改书籍</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/book/updateBook" method="post">
    <input type="text" name="bookID" value="${book.bookID}" readonly>
    <label>名称：
        <input type="text" name="bookName" value="${book.bookName}" required>
    </label>
    <label>数量：
        <input type="text" name="bookCounts" value="${book.bookCounts}" required>
    </label>
    <label>详情：
        <input type="text" name="detail" value="${book.detail}" required>
    </label>
    <input type="submit" value="修改">
</form>

<h1></h1>

</body>
</html>
