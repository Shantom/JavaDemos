<%--
  Created by IntelliJ IDEA.
  User: ningwei.shi
  Date: 2021/1/29
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="${pageContext.request.contextPath}/static/js/jquery-3.5.1.js"></script>
    <script>
        function a() {
            $.post('${pageContext.request.contextPath}/a2',
                function (data) {
                    console.log(data);
                    console.log(123);
                    let html = "";
                    for (let i=0; i<data.length; i++){
                        html += "<tr>" +
                            "<td>"+data[i].id+"</td>"+
                            "<td>"+data[i].name+"</td>"+
                            "<td>"+data[i].age+"</td>"+
                            "</tr>"
                    }
                    console.log(html);
                    $("#content").html(html);
                }
            );


        }
    </script>
</head>
<body>

    <input type="button" value="load" id="btn" onclick="a()">
    <table>
        <tr>
            <td>ID</td>
            <td>姓名</td>
            <td>年龄</td>
        </tr>
        <tbody id="content">

        </tbody>
    </table>

</body>
</html>
