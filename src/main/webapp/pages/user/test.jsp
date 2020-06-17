<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2020/6/14
  Time: 0:42
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
    测试Spring security不同权限跳转


<form action="${pageContext.request.contextPath}/addImg.do" method="post" enctype="multipart/form-data">
        <table >
            <tr>
                <td>上传图片：</td>
                <td><input type="file" name="file" /></td><!--这个name=“file”并不是数据库的字段名哦-->
            </tr>
        </table>
        <button type="submit" >保存</button>
</form>

</p>
</body>
</html>
