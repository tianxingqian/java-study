<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/7
  Time: 11:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>index</title>
</head>
<%
  pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
<form action="${ctp}/hello/hello" method="post">
  <input type="text" name="username"><br>
  <input type="submit" value="提交">
</form>
</body>
</html>
