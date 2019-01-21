<%@ page language="java" import="xflfk.wicresoft.entitry.User"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>User-Lucy_Book</title>
<link href="../style.css" rel="stylesheet">
<link href="../css/themetypo.css" rel="stylesheet">
<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/color.css" rel="stylesheet">
<link href="../css/font-awesome.min.css" rel="stylesheet">
<link href="../css/jquery.bxslider.css" rel="stylesheet">
<link href="../css/bootstrap-slider.css" rel="stylesheet">
<link href="../css/widget.css" rel="stylesheet">
<link href="../css/shortcode.css" rel="stylesheet">
<link href="../css/responsive.css" rel="stylesheet">
<link href="../js/dl-menu/component.css" rel="stylesheet">
<%
	String tag1 = "登录";
	String tag2 = "注册";
	String href1 = "user_Login.jsp";
	String href2 = "user_Register.jsp";
	if (session.getAttribute("user") != null) {
		User u = (User) session.getAttribute("user");
		tag1 = u.getuName();
		tag2 = "登出";
		href1 = "#";
		href2 = "user_loginOut";
	}
%>
<script type="text/javascript">
	function click1() {
		if (confirm("发送邮件给店家？"))
			return true;
		else
			return false;
	}
</script>
</head>
<body>
	<div id="loader-wrapper">
		<div id="loader"></div>

		<div class="loader-section section-left"></div>
		<div class="loader-section section-right"></div>

	</div>
	<!--WRAPPER START-->
	<div class="wrapper kode-header-class-3">
		<!--HEADER START-->
		<header class="header-3">
		<div class="container">
			<div class="logo-container">
				<div class="row">
					<div class="col-md-3">
						<!--LOGO START-->
						<div class="logo">
							<a href="#"><img src="../images/logo-2.png" alt=""></a>
						</div>
						<!--LOGO END-->
					</div>
					<div class="col-md-9">
						<div class="top-strip">
							<div class="pull-left">
								<p>欢迎来到Lucy_Book网上书城</p>
							</div>
							<div class="social-icon">
								<div class="social-icon">
									<a href="<%=href1%>" class="pull-left"><%=tag1%></a> <a
										href="<%=href2%>" class="pull-left"><%=tag2%></a> <a
										href="mailto:1814375626@qq.com" class="pull-left">联系我们</a>
								</div>
							</div>
							<div class="kode-navigation">
								<ul>
									<li><a
										href="${pageContext.request.contextPath }/User/pages/user_homeContent">主页</a></li>
									<li><a
										href="${pageContext.request.contextPath }/User/pages/user_allBook?pages=1">书库</a></li>
									<li><a
										href="${pageContext.request.contextPath }/User/pages/user_allAuthor?pages=1">作者</a></li>
									<li><a href="blog.html">类型</a>
										<ul>
											<c:forEach items="${stortlist1 }" var="ast">
												<li><a
													href="${pageContext.request.contextPath }/User/pages/user_stortToBooks?id=${ast.stid}">${ast.stName }</a></li>
											</c:forEach>
										</ul></li>
									<li><a href="blog.html">我的</a>
										<ul>
											<li><a href="#">个人信息</a></li>
											<li><a
												href="${pageContext.request.contextPath }/User/pages/user_myConsigness">我的收货人</a></li>
											<li><a href="${pageContext.request.contextPath }/User/pages/user_shoppingCart">我的购物车</a></li>
										</ul></li>
									<li><a href="blog.html">订单管理</a>
										<ul>
											<li><a href="authors.html">已完成订单</a></li>
											<li><a href="author-detail.html">待付款订单</a></li>
											<li><a href="author-detail.html">未发货订单</a></li>
										</ul></li>
									<li><a
										href="${pageContext.request.contextPath}/Admin/pages/admin_Login.jsp">书店后台</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!--HEADER END-->
		<!--BANNER START-->
		<div class="kode-inner-banner">
			<div class="kode-page-heading">
				<h2>已完成订单</h2>
				<ol class="breadcrumb">
					<li>轻松  自在</li>
				</ol>
			</div>
		</div>
		<!--BANNER END-->
		<div class="search-section">
			<div class="container">
				<!-- Nav tabs -->
				<ul class="nav nav-tabs" role="tablist">
					<li role="presentation"><a href="#Basic" role="tab"
						data-toggle="tab">(✪ω✪) </a></li>
					<li role="presentation" class="active"><a href="#Author"
						role="tab" data-toggle="tab">(๑*◡*๑)</a></li>
					<li role="presentation"><a href="#Publications" role="tab"
						data-toggle="tab">(๑´ㅂ`๑) </a></li>
				</ul>
			</div>
		</div>
		<div class="kode-content padding-tb-50">
			<div class="container">
				<table class="table table-striped">
	<caption>已完成订单</caption>
	<thead>
		<tr>
			<th>订单编号</th>
			<th>总金额</th>
			<th>付款状态</th>
			<th>发货状态</th>
			<th>创建时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${ordtlist }" var="ol">
		<tr>
			<td>${ol.ordid }</td>
			<td>${ol.ordTotal }</td>
			<td>${ol.ordPayState }</td>
			<td>${ol.ordSendState }</td>
			<td>${ol.ordTime }</td>
			<td>
			<a href="${pageContext.request.contextPath}/User/pages/user_payOrdDetail?ordid=${ol.ordid}">查看明细</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
			</div>
		</div>
	</div>
	<footer class="footer-2">
	<div class="container">
		<div class="lib-copyrights">
			<p>版权所有Lucy_Book © 2018仿冒必究.</p>
		</div>
		<div class="back-to-top">
			<a href="#home"><i class="fa fa-angle-up"></i></a>
		</div>
	</div>
	</footer>
	<!--WRAPPER END-->
	<script src="../js/jquery.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/dl-menu/modernizr.custom.js"></script>
	<script src="../js/dl-menu/jquery.dlmenu.js"></script>
	<script src="../js/jquery.bxslider.min.js"></script>
	<script src="../js/bootstrap-slider.js"></script>
	<script src="../js/waypoints.min.js"></script>
	<script src="../js/jquery.counterup.min.js"></script>
	<script src="../js/functions.js"></script>
</body>
</html>