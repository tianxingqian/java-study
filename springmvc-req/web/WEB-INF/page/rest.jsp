<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2020/3/6
  Time: 23:01
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
<form action="${ctx}/user" method="post">
    <input type="submit" value="增加">
</form>
<form action="${ctx}/user/1" method="post">
    <input name="_method" value="delete" type="hidden">
    <input type="submit" value="删除">
</form>
<form action="${ctx}/user/1" method="post">
    <input name="_method" value="put" type="hidden">
    <input type="submit" value="修改">
</form>
<a href="${ctx}/user/1">查询</a><br/>
</body>
</html>