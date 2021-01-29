<%--
  Created by IntelliJ IDEA.
  User: ningwei.shi
  Date: 2021/1/29
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>

  <script>
    function a() {
      $.post({
        url:"${pageContext.request.contextPath}/a1",
        data:{
          "name":$("#name").val()
        },
        success:function (data, status) {
          console.log('data:'+data);
          console.log('status:'+status);
        }
      });
    }
  </script>


  <input type="text" id="name" value="" onblur="a()">




  </body>
</html>
