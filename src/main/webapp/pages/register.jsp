<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>失物招领网 | Register </title>

    <meta
            content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
            name="viewport">

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">

    <script type="text/javascript">
        function beforeSubmit(form){
            if(form.username.value===''){
                alert('用户名不能为空！');
                form.username.focus();
                return false;
            }
            if(form.password.value===''){
                alert('密码不能为空！');
                form.password.focus();
                return false;
            }
            return true;
        }
    </script>

</head>



<body class="hold-transition login-page" style="background-image: url('/img/background1.jpg')">

<nav class="navbar navbar-inverse">


    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/findSomeMess.do">失物招领网</a>
        </div>


        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/login.jsp">登录</a></li>
            </ul>
        </div>
    </div>
</nav>
<div class="login-box">
    <div class="login-logo">
        <a href="all-admin-index.html"><b>失物招领网</b></a>
    </div>
    <!-- /.login-logo -->
    <div class="login-box-body">
        <p class="login-box-msg">注册</p>

        <form action="${pageContext.request.contextPath}/register.do" name="form" method="post" onSubmit="return beforeSubmit(this);">
            <div class="form-group has-feedback">
                <input type="text" name="username" class="form-control" placeholder="*用户名">
                <span class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="password" class="form-control" placeholder="*密码">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="mobile" class="form-control" placeholder="联系电话">
                <span class="glyphicon glyphicon-phone-alt form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                    <label id="sex" style="margin-right: 30px">性别</label>
                    <label><input type="radio" name="sex" value="男" >男</label>
                    <label><input type="radio" name="sex" value="女" >女</label>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="email" class="form-control" placeholder="邮箱">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <input type="hidden" name="classno" value="0" >
            <input type="hidden" name="status" value="1" >
            <div class="row">

                <!-- /.col -->
                <div class="col-xs-4 " >
                    <button type="submit" class="btn btn-primary btn-block btn-flat" style="margin-left: 130%">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="${pageContext.request.contextPath}/login.jsp">已有账号，立即登录！</a>


    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script
        src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function() {
        $('input').iCheck({
            checkboxClass : 'icheckbox_square-blue',
            radioClass : 'iradio_square-blue',
            increaseArea : '20%' // optional
        });
    });
</script>
</body>

</html>