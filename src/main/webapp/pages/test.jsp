<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/14
  Time: 1:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>测试Spring security不同权限跳转</title>
</head>
<body>
<p>
    页面路径：pages/test.jsp<br>
    <c:forEach items="${pageInfo.list}" var="mess">
        ${mess.description}
    </c:forEach>
</p>
</body>
</html>
