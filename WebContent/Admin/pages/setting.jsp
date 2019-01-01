<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
	<head>
		<!-- Required meta tags -->
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<title>Purple Admin</title>
		<link rel="stylesheet" href="../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
		<link rel="stylesheet" href="../vendors/css/vendor.bundle.base.css">
		<link rel="stylesheet" href="../css/style.css">
		<link rel="shortcut icon" href="../images/favicon.png" />
		<%
		if(request.getAttribute("settingIsOk")!=null){
		%>
		<script type="text/javascript">
		alert("设置成功！");
		</script>
		<%
		}
		%>
	</head>
	<body>
		<div class="container-scroller">
			<!-- partial:../../partials/_navbar.html -->
						<nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
				<div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
					<a class="navbar-brand brand-logo" href="#"><img src="../images/logo.svg" alt="logo" /></a>
					<a class="navbar-brand brand-logo-mini" href="#"><img src="../images/logo-mini.svg" alt="logo" /></a>
				</div>
				<div class="navbar-menu-wrapper d-flex align-items-stretch">
					<div class="search-field d-none d-md-block">
						<form class="d-flex align-items-center h-100" action="#">
							<div class="input-group">
								<div class="input-group-prepend bg-transparent">
									<i class="input-group-text border-0 mdi mdi-magnify"></i>
								</div>
								<input type="text" class="form-control bg-transparent border-0" placeholder="搜索">
							</div>
						</form>
					</div>
					<ul class="navbar-nav navbar-nav-right">
						<li class="nav-item nav-profile dropdown">
							<a class="nav-link dropdown-toggle" id="profileDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
								<div class="nav-profile-img">
									<img src="${sessionScope.admin.admPor }" alt="image">
									<span class="availability-status online"></span>
								</div>
								<div class="nav-profile-text">
									<p class="mb-1 text-black">${sessionScope.admin.admName }</p>
								</div>
							</a>
							<div class="dropdown-menu navbar-dropdown" aria-labelledby="profileDropdown">
								<a class="dropdown-item" href="#">
									<i class="mdi mdi-cached mr-2 text-success"></i> 个人信息
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="admin_Login.jsp">
									<i class="mdi mdi-logout mr-2 text-primary"></i> 登出
								</a>
							</div>
						</li>
						<li class="nav-item d-none d-lg-block full-screen-link">
							<a class="nav-link">
								<i class="mdi mdi-fullscreen" id="fullscreen-button"></i>
							</a>
						</li>
						
						<li class="nav-item nav-logout d-none d-lg-block">
							<a class="nav-link" href="admin_Login.jsp">
								<i class="mdi mdi-power"></i>
							</a>
						</li>
						<li class="nav-item nav-settings d-none d-lg-block">
							<a class="nav-link" href="#">
								<i class="mdi mdi-format-line-spacing"></i>
							</a>
						</li>
					</ul>
				</div>
			</nav>
			<div class="container-fluid page-body-wrapper">
				<nav class="sidebar sidebar-offcanvas" id="sidebar">
					<ul class="nav">
						<li class="nav-item nav-profile">
							<a href="#" class="nav-link">
								<div class="nav-profile-image">
									<img src="${sessionScope.admin.admPor }" alt="profile">
									<span class="login-status online"></span>
								</div>
								<div class="nav-profile-text d-flex flex-column">
									<span class="font-weight-bold mb-2">${sessionScope.admin.admName }</span>
									<span class="text-secondary text-small">书店管理员</span>
								</div>
								<i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">
								<span class="menu-title">书店主页</span>
								<i class="mdi mdi-home menu-icon"></i>
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-basic4" aria-expanded="false" aria-controls="ui-basic4">
								<span class="menu-title">账户管理</span>
								<i class="menu-arrow"></i>
								<i class="mdi mdi-binoculars menu-icon"></i>
							</a>
							<div class="collapse" id="ui-basic4">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link" href="addAdmin.jsp">添加管理员</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">管理员管理</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">用户管理</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-basic" aria-expanded="false" aria-controls="ui-basic">
								<span class="menu-title">书本管理</span>
								<i class="menu-arrow"></i>
								<i class="mdi mdi-crosshairs-gps menu-icon"></i>
							</a>
							<div class="collapse" id="ui-basic">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link" href="${pageContext.request.contextPath}/Admin/pages/admin_showBook?pages=1">所有书本</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="${pageContext.request.contextPath}/Admin/pages/admin_showAddBook">新书上架</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="${pageContext.request.contextPath}/Admin/pages/admin_inveAlarm?pages=1">库存警报</a>
<!-- 									</li> -->
									<li class="nav-item">
										<a class="nav-link" href="#">编辑书本</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-basic1" aria-expanded="false" aria-controls="ui-basic1">
								<span class="menu-title">类型管理</span>
								<i class="menu-arrow"></i>
								<i class="mdi mdi-contacts menu-icon"></i>
							</a>
							<div class="collapse" id="ui-basic1">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link" href="#">所有类型</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">新增类型</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">编辑类型</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">删除类型</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-basic3" aria-expanded="false" aria-controls="ui-basic3">
								<span class="menu-title">作者管理</span>
								<i class="menu-arrow"></i>
								<i class="mdi mdi-cake menu-icon"></i>
							</a>
							<div class="collapse" id="ui-basic3">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link" href="#">所有作者</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">新增作者</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">编辑作者</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">删除作者</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" data-toggle="collapse" href="#ui-basic5" aria-expanded="false" aria-controls="ui-basic5">
								<span class="menu-title">订单管理</span>
								<i class="menu-arrow"></i>
								<i class="mdi mdi-biohazard menu-icon"></i>
							</a>
							<div class="collapse" id="ui-basic5">
								<ul class="nav flex-column sub-menu">
									<li class="nav-item">
										<a class="nav-link" href="#">所有订单</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">待支付订单</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">已支付订单</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" href="#">账单统计</a>
									</li>
								</ul>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="setting.jsp">
								<span class="menu-title">设置</span>
								<i class="mdi mdi-brightness-7 menu-icon"></i>
							</a>
						</li>
					</ul>
				</nav>
				<!-- partial -->
				<div class="content-wrapper">
					<p class="text-primary" style="b">Lucy_Book--设置</p>
					<div class="col-12 grid-margin stretch-card">
						<div class="card-body">
							<h4 class="card-title">网站的相关设置</h4>
							<p class="card-description">
								变成你所喜欢的样子
							</p>
							<form class="forms-sample" action="${pageContext.request.contextPath}/Admin/pages/admin_setting" method="post">
								<div class="form-group row">
									<label for="exampleInputUsername2" class="col-sm-3 col-form-label">分页设置</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="exampleInputUsername2" placeholder="设置一个你喜欢的展示条数" name="bookStore">
									</div>
								</div>
								<div class="form-group row">
									<label for="exampleInputUsername2" class="col-sm-3 col-form-label">库存警报设置</label>
									<div class="col-sm-9">
										<input type="text" class="form-control" id="exampleInputUsername3" placeholder="设置一个适合本书店的库存警报数量" name="bookStort">
									</div>
								</div>
								<button type="submit" class="btn btn-gradient-primary mr-2" >修改</button>
								<button type="reset" class="btn btn-light">重置</button>
							</form>
						</div>
					</div>
					<footer class="footer">
						<div class="d-sm-flex justify-content-center justify-content-sm-between">
							<span class="text-muted text-center text-sm-left d-block d-sm-inline-block">版权所有 © 2017 <a href="#" target="_blank">Lucy_Book</a>. 仿冒必究.</span>
							<span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">感谢您的选择和信赖
              <i class="mdi mdi-heart text-danger"></i> - 我们将打造更优秀的平台 <a href="#" target="_blank" title="Lucy_Book">Lucy_Book</a> - 联系我们<a href="#" title="1814375626@qq.com" target="_blank">1814375626@qq.com</a></span>
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