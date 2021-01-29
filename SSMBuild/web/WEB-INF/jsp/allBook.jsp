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
    <title>所有书籍</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/book/queryLike" method="post">
        <input type="text" name="name" placeholder="输入查询的名称">
        <input type="submit" value="查询">
        <span style="color: red">${error}</span>
    </form>


    <table>
        <thead>
            <tr>
                <th>编号</th>
                <th>名称</th>
                <th>数量</th>
                <th>详情</th>
                <th>修改</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="book" items="${list}">
                <tr>
                    <td>${book.bookID}</td>
                    <td>${book.bookName}</td>
                    <td>${book.bookCounts}</td>
                    <td>${book.detail}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/book/toUpdateBook?id=${book.bookID}">修改</a>
                        &nbsp;|&nbsp;
                        <a href="${pageContext.request.contextPath}/book/delBook/${book.bookID}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/book/toAddBook">添加书籍</a>

<h1></h1>

</body>
</html>
