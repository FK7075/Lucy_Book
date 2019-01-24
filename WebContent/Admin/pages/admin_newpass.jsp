<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Purple Admin</title>
<link rel="stylesheet"
	href="../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="../vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="shortcut icon" href="../images/favicon.png" />
</head>
<%
	if (request.getAttribute("IsOk") != null) {
%>
<script type="text/javascript">
	alert("类型添加成功！");
</script>
<%
	}
%>
<script type="text/javascript">
	function Click() {
		var info = "${sessionScope.admin.admid}";
		if (info != "1" && info != "2") {
			alert("抱歉，您的权限不够！");
			return false;
		} else {
			return true;
		}
	}
	function click_xfl() {
		var old = document.getElementById('old').value;
		var new1 = document.getElementById('new1').value;
		var new2 = document.getElementById('new2').value;
		if (old == "" || new1 == "" || new2 == "") {
			alert("请将修改信息填写完整");
			return false;
		} else {
			if (old != "${sessionScope.admin.admPassword}") {
				alert("旧密码输入错误，请检查后重新输入！");
				return false;
			} else {
				if (new1 != new2) {
					alert("两次输入的密码不一致！");
					return false;
				} else {
					return true;
				}
			}
		}
	}
</script>
<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->
		<nav
			class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
		<div
			class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
			<a class="navbar-brand brand-logo" href="#"><img
				src="../images/logo.svg" alt="logo" /></a> <a
				class="navbar-brand brand-logo-mini" href="#"><img
				src="../images/logo-mini.svg" alt="logo" /></a>
		</div>
		<div class="navbar-menu-wrapper d-flex align-items-stretch">
			<div class="search-field d-none d-md-block">
				<form class="d-flex align-items-center h-100" action="#">
					<div class="input-group">
						<div class="input-group-prepend bg-transparent">
							<i class="input-group-text border-0 mdi mdi-magnify"></i>
						</div>
						<input type="text" class="form-control bg-transparent border-0"
							placeholder="搜索">
					</div>
				</form>
			</div>
			<ul class="navbar-nav navbar-nav-right">
				<li class="nav-item nav-profile dropdown"><a
					class="nav-link dropdown-toggle" id="profileDropdown" href="#"
					data-toggle="dropdown" aria-expanded="false">
						<div class="nav-profile-img">
							<img
								src="${pageContext.request.contextPath }/${sessionScope.admin.admPor }"
								alt="image"> <span class="availability-status online"></span>
						</div>
						<div class="nav-profile-text">
							<p class="mb-1 text-black">${sessionScope.admin.admName }</p>
						</div>
				</a>
					<div class="dropdown-menu navbar-dropdown"
						aria-labelledby="profileDropdown">
						<a class="dropdown-item" href="admin_newpass.jsp"> <i
							class="mdi mdi-cached mr-2 text-success"></i> 修改密码
						</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/Admin/pages/admin_loginOut">
							<i class="mdi mdi-logout mr-2 text-primary"></i> 登出
						</a>
					</div></li>
				<li class="nav-item d-none d-lg-block full-screen-link"><a
					class="nav-link"> <i class="mdi mdi-fullscreen"
						id="fullscreen-button"></i>
				</a></li>

				<li class="nav-item nav-logout d-none d-lg-block"><a
					class="nav-link"
					href="${pageContext.request.contextPath}/Admin/pages/admin_loginOut">
						<i class="mdi mdi-power"></i>
				</a></li>
				<li class="nav-item nav-settings d-none d-lg-block"><a
					class="nav-link" href="#"> <i
						class="mdi mdi-format-line-spacing"></i>
				</a></li>
			</ul>
		</div>
		</nav>
		<div class="container-fluid page-body-wrapper">
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
			<ul class="nav">
				<li class="nav-item nav-profile"><a href="#" class="nav-link">
						<div class="nav-profile-image">
							<img
								src="${pageContext.request.contextPath }/${sessionScope.admin.admPor }"
								alt="profile"> <span class="login-status online"></span>
						</div>
						<div class="nav-profile-text d-flex flex-column">
							<span class="font-weight-bold mb-2">${sessionScope.admin.admName }</span>
							<span class="text-secondary text-small">书店管理员</span>
						</div> <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
				</a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath }/User/pages/user_homeContent">
						<span class="menu-title">书店主页</span> <i
						class="mdi mdi-home menu-icon"></i>
				</a></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#ui-basic4" aria-expanded="false" aria-controls="ui-basic4">
						<span class="menu-title">账户管理</span> <i class="menu-arrow"></i> <i
						class="mdi mdi-binoculars menu-icon"></i>
				</a>
					<div class="collapse" id="ui-basic4">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link" href="addAdmin.jsp"
								onclick="return Click();">添加管理员</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/account_allAdmin?pages=1"
								onclick="return Click();">管理员管理</a></li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/account_allUser?pages=1"
								onclick="return Click();">用户管理</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
						<span class="menu-title">书本管理</span> <i class="menu-arrow"></i> <i
						class="mdi mdi-crosshairs-gps menu-icon"></i>
				</a>
					<div class="collapse" id="ui-basic">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_showBook?pages=1">所有书本</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_showAddBook">新书上架</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_inveAlarm?pages=1">库存警报</a>
							</li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#ui-basic1" aria-expanded="false" aria-controls="ui-basic1">
						<span class="menu-title">类型管理</span> <i class="menu-arrow"></i> <i
						class="mdi mdi-contacts menu-icon"></i>
				</a>
					<div class="collapse" id="ui-basic1">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_showStort?pages=1">所有类型</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="admin_AddStort.jsp">新增类型</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#ui-basic3" aria-expanded="false" aria-controls="ui-basic3">
						<span class="menu-title">作者管理</span> <i class="menu-arrow"></i> <i
						class="mdi mdi-cake menu-icon"></i>
				</a>
					<div class="collapse" id="ui-basic3">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_showAuthor?pages=1">所有作者</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="admin_AddAuthor.jsp">新增作者</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#ui-basic9" aria-expanded="false" aria-controls="ui-basic9">
						<span class="menu-title">美文管理</span> <i class="menu-arrow"></i> <i
						class="mdi mdi-apple-finder menu-icon"></i>
				</a>
					<div class="collapse" id="ui-basic9">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_showNotes">所有美文</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="admin_addNotes.jsp">新增美文</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link" data-toggle="collapse"
					href="#ui-basic5" aria-expanded="false" aria-controls="ui-basic5">
						<span class="menu-title">订单管理</span> <i class="menu-arrow"></i> <i
						class="mdi mdi-biohazard menu-icon"></i>
				</a>
					<div class="collapse" id="ui-basic5">
						<ul class="nav flex-column sub-menu">
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_showOrder?pages=1">所有订单</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_noPayment?pages=1">待支付订单</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_noDelivery?pages=1">待发货订单</a>
							</li>
							<li class="nav-item"><a class="nav-link"
								href="${pageContext.request.contextPath}/Admin/pages/admin_statistical">数据统计</a></li>
						</ul>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/Admin/pages/admin_showSetting">
						<span class="menu-title">设置</span> <i
						class="mdi mdi-brightness-7 menu-icon"></i>
				</a></li>
			</ul>
			</nav>
			<!-- partial -->
			<div class="content-wrapper">
				<p class="text-primary" style="">Lucy_Book--修改密码</p>
				<div class="col-12 grid-margin stretch-card">
					<div class="card-body">
						<h4 class="card-title">修改密码</h4>
						<form class="forms-sample"
							action="${pageContext.request.contextPath}/Admin/pages/account_a_newPassword"
							method="post">
							<div class="form-group row">
								<label for="exampleInputUsername2"
									class="col-sm-3 col-form-label">旧密码</label>
								<div class="col-sm-9">
									<input type="password" class="form-control"
										id="old" placeholder="输入您的旧密码"
										name="bookName">
								</div>
								<label for="exampleInputUsername2"
									class="col-sm-3 col-form-label">新密码</label>
								<div class="col-sm-9">
									<input type="password" class="form-control"
										id="new1" placeholder="输入您的新密码"
										name="uSex">
								</div>
								<label for="exampleInputUsername2"
									class="col-sm-3 col-form-label">确认密码</label>
								<div class="col-sm-9">
									<input type="password" class="form-control"
										id="new2" placeholder="再此输入"
										name="bookName">
								</div>
							</div>
							<button onclick="return click_xfl();" type="submit" class="btn btn-gradient-primary mr-2">修改</button>
							<button type="reset" class="btn btn-light">重置</button>
						</form>
					</div>
				</div>
				<footer class="footer">
				<div
					class="d-sm-flex justify-content-center justify-content-sm-between">
					<span
						class="text-muted text-center text-sm-left d-block d-sm-inline-block">版权所有
						© 2017 <a href="#" target="_blank">Lucy_Book</a>. 仿冒必究.
					</span> <span
						class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">感谢您的选择和信赖
						<i class="mdi mdi-heart text-danger"></i> - 我们将打造更优秀的平台 <a
						href="#" target="_blank" title="Lucy_Book">Lucy_Book</a> - 联系我们<a
						href="#" title="1814375626@qq.com" target="_blank">1814375626@qq.com</a>
					</span>
				</div>
				</footer>
			</div>
		</div>
	</div>
	<script src="../vendors/js/vendor.bundle.base.js"></script>
	<script src="../vendors/js/vendor.bundle.addons.js"></script>
	<script src="../js/off-canvas.js"></script>
	<script src="../js/misc.js"></script>
	<script src="../js/file-upload.js"></script>
</body>

</html>