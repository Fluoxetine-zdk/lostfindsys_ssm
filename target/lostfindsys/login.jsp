<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>失物招领网 | Log in</title>

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

<body class="hold-transition login-page" style="background-image: url('img/background1.jpg')">

<nav class="navbar navbar-inverse">


	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/findSomeMess.do">失物招领网</a>
		</div>


		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/pages/register.jsp">注册</a></li>
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
			<p class="login-box-msg">登录</p>

			<form action="${pageContext.request.contextPath}/login.do" method="post" name="form" onSubmit="return beforeSubmit(this);">
				<div class="form-group has-feedback">
					<input type="text" name="username" class="form-control"
						placeholder="用户名"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control"
						placeholder="密码">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
					<span style="color: red"><%=(request.getAttribute("msg")!=null)?request.getAttribute("msg"):""%></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label><input type="checkbox"> 记住 下次自动登录</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<a href="#">忘记密码</a><br><a href="pages/register.jsp">没有账号，立即注册！</a>


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