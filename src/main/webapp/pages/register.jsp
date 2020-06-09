<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/5
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <h2>注册</h2>
    <form action="/user/registering" method="post">
        用户名<input type="text" id="username" name="username"><br>
        密码<input type="text" id="password" name="password"><br>
        电话<input type="text" id="mobile" name="mobile"><br>
        <input type="submit" value="提交">
    </form>

</body>
</html>
