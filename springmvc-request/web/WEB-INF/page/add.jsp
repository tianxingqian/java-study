<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2020/3/7
  Time: 0:11
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
<form action="${ctx}/addUser" method="post">
    编号:<input type="text" name="id"/>

    姓名:<input type="text" name="name"/>

    年龄:<input type="text" name="age"/>

    省份:<input type="text" name="address.province"/>

    城市:<input type="text" name="address.city"/>

    区域:<input type="text" name="address.town"/>

    <input type="submit" value="submit"/>

</form>
</body>
</html>
