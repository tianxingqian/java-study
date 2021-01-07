<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/7
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setAttribute("ctx", request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ok!!! <br>
    <a href="${ctx}/rest">返回</a>
</body>
</html>
