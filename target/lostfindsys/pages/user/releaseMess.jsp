
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>失物招领网 | 发布信息</title>

    <!-- Tell the browser to be responsive to screen width -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

    <style>
        .example-modal .modal {
            position: relative;
            top: auto;
            bottom: auto;
            right: auto;
            left: auto;
            display: block;
            z-index: 1;
            height: 700px;
            background-color: whitesmoke;
        }
        .example-modal.container {
            padding: 30px;
            margin: 0 auto;
            background: #fff;
            border: 1px solid #ccc;
            width: 45%;
            margin: 0 auto;
        }
    </style>


    <script type="text/javascript">
        function formReset()
        {
            document.getElementById("frm1").reset();

        }
        function beforeSubmit(form){
            if(form.address.value===''){
                alert('地点不能为空！');
                form.address.focus();
                return false;
            }
            if(form.description.value===''){
                alert('物品描述不能为空！');
                form.description.focus();
                return false;
            }
            if(form.username.value===''){
                alert('姓名不能为空！');
                form.username.focus();
                return false;
            }
            return true;
        }
    </script>

</head>


<body>

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
                <li><a href="${pageContext.request.contextPath}/pages/user/releaseMess.jsp">发布信息</a></li>
                <li><a href="${pageContext.request.contextPath}/logout.do">注销</a></li>

            </ul>
        </div>
    </div>
</nav>

<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">发布信息
        <small>Release Message</small>
    </h1>

    <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath}/pages/user/releaseMess.jsp"><i class="fa fa-dashboard"></i> 首页</a></li>
        <li class="breadcrumb-item active">信息发布</li>
    </ol>
    <form action="${pageContext.request.contextPath}/releaseMess.do" method="post" id="frm1" name="form" enctype="multipart/form-data" onSubmit="return beforeSubmit(this);">
        <!-- 正文区域 -->


            <div class="panel panel-default">
                <div class="row data-type">
                    <div class="col-md-2 title">用户账号</div>
                    <div class="col-md-4 data">
                        <input type="text" disabled class="form-control"
                               value="<security:authentication property="principal.username"></security:authentication>">
                        <input type="hidden"  class="form-control" name="username"
                               value="<security:authentication property="principal.username"></security:authentication>">
                    </div>
                    <div class="col-md-2 title">丢失地点</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" name="address"
                               placeholder="详细地址" value="">
                    </div>

                    <div class="col-md-2 title">酬金</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="金额"
                               name="reward" value="0">
                    </div>

                    <div class="col-md-2 title">信息类别</div>
                    <div class="col-md-4 data">
                        <select class="form-control select2" style="width: 100%"
                                name="class_message">
                                <option value="0">失物信息</option>
                                <option value="1">招领信息</option>
                        </select>
                    </div>

                    <div class="col-md-2 title">上传图片</div>
                    <div class="col-md-10 data">
                        <input type="file" class="form-control" name="file" >
                    </div>

                    <div class="col-md-2 title rowHeight2x">信息详情</div>
                    <div class="col-md-10 data rowHeight2x">
							<textarea class="form-control" rows="3"
                                      name="description"></textarea>
                    </div>
                </div>
            </div>

            <!--订单信息/--> <!--工具栏-->

            <div class="col-md-10 col-lg-offset-1 data text-center" style="margin-top: 15px">
                <button type="submit" class="btn bg-maroon">发布</button>
                <button type="button" class="btn bg-default" onclick="formReset()" >重置</button>
                <button type="button" class="btn bg-default" onclick="history.back(-1);">返回</button>
            </div>
            <!--工具栏/--> </section>
        <!-- 正文区域 /-->
    </form>
</div>
    <!-- /.example-modal -->


</body>

</html>
