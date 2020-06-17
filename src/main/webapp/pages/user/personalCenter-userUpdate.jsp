<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>个人信息主页</title>

    <!-- Bootstrap core CSS -->
    <link href="/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/plugins/bootstrap/css/modern-business.css" rel="stylesheet">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">

</head>

<body>

<!-- Navigation -->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/usermain.do">失物招领网</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">
                    <security:authentication property="principal.username"></security:authentication>
                </a>
                </li>
                <li><a href="${pageContext.request.contextPath}/">发布信息</a></li>
                <li><a href="${pageContext.request.contextPath}/logout.do">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
<!-- Page Content -->

<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">基本信息
        <small>messages</small>
    </h1>

    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/backstage/backstage-main.jsp"><i
                class="fa fa-dashboard"></i> 首页</a></li>
        <li class="breadcrumb-item active">About</li>
    </ol>

    <!-- Content Row -->
    <div class="row">
        <!-- Sidebar Column -->
        <div class="col-lg-3 mb-4">
            <div class="list-group">
                <a href="${pageContext.request.contextPath}/" class="list-group-item">个人信息</a>
                <a href="${pageContext.request.contextPath}/role/findAll.do" class="list-group-item">发布信息</a>
            </div>
        </div>
        <!-- Content Column -->
        <div class="col-lg-9 mb-5">
            <h3>修改个人信息</h3>
            <form action="${pageContext.request.contextPath}/usertoUpdate.do" method="post">
            <div class="col-md-4 text-center">用户账号</div>
            <div class="col-md-8 data">
                <input type="text" disabled class="form-control"  value="${user.username}">
                <input type="hidden" class="form-control" name="username" value="${user.username}">
            </div>
            <div class="col-md-4 text-center">密码</div>
            <div class="col-md-8 data">
                <input type="text" class="form-control" name="password" value="${user.password}">
            </div>
            <div class="col-md-4 text-center">性别</div>
            <div class="col-md-8 data">
                <c:if test="${user.sex.equals('男')}">
                    <label><input type="radio" name="sex" value="男" checked>男</label>
                    <label><input type="radio" name="sex" value="女">女</label>
                </c:if>
                <c:if test="${user.sex.equals('女')}">
                    <label><input type="radio" name="sex" value="男">男</label>
                    <label><input type="radio" name="sex" value="女" checked>女</label>
                </c:if>
                <c:if test="${user.sex == null}">
                    <label><input type="radio" name="sex" value="男">男</label>
                    <label><input type="radio" name="sex" value="女">女</label>
                </c:if>
            </div>

            <div class="col-md-4 text-center">联系电话</div>
            <div class="col-md-8 data">
                <input type="text" class="form-control" name="mobile" value="${user.mobile}">
            </div>
            <div class="col-md-4 text-center">邮箱地址</div>
            <div class="col-md-8 data">
                <input type="text" class="form-control" name="mobile"
                       placeholder="邮箱地址" value="">
            </div>

        </div>
    </div>
    <br />
    <br />
    <!--订单信息/--> <!--工具栏-->
    <div class="box-tools text-center">
        <button type="submit" class="btn bg-maroon"  >保存</button>
        <button type="button" class="btn bg-default"
                onclick="history.back(-1);">返回</button>
    </div>
</div>
</div>
<!-- /.row -->

</div>
</form>
<!-- /.container -->
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<br />

<%--<!-- Footer -->--%>
<%--<footer class="md-footer">--%>
<%--    <div class="container">--%>
<%--        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>--%>
<%--    </div>--%>
    <!-- /.container -->
</footer>

<!-- Bootstrap core JavaScript -->
<script src="/plugins/bootstrap/js/jquery.min.js"></script>
<script src="/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
