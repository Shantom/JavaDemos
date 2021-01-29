<%--
  Created by IntelliJ IDEA.
  User: ningwei.shi
  Date: 2021/1/29
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名:<input type="text" name="name">
    密码:<input type="password" name="password">
    <input type="submit" value="提交">
</form>

</body>
</html>
