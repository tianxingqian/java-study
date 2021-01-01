<%--
  Created by IntelliJ IDEA.
  User: Will
  Date: 2021/1/1
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.lang.Math" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        double random = Math.random();
        System.out.println(random);
    %>
    <br>
    <%=random%>
</body>
</html>
