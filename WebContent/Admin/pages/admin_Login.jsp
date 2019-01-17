<%@ page language="java" import="java.net.URLDecoder"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>管理员登录</title>
<link rel="stylesheet"
	href="../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="../vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="shortcut icon" href="../images/favicon.png" />
<%
	if (request.getAttribute("isOk") != null) {
%>
<script type="text/javascript">
alert("用户名与密码不匹配！")
</script>
<%
	}
%>
<script>
function loadHandle(){
	var info="${sessionScope.admin}"
	if(info!=""){
		window.location.href="${pageContext.request.contextPath}/Admin/pages/admin_showBook?pages=1";
	}
}
function Click5(){
	if (confirm("联系管理员邮箱1814375626@qq.com找回密码？"))
		return true;
	else
		return false;
}
</script>
<%
	Cookie[] cookies = request.getCookies();
	String ID = "";
	String Pass = "";
	String cookieName = "LB_adminID";
	String cookiePass = "LB_adminPass";
	String ppt = "";
	Cookie[] cookiepp = request.getCookies();
	if (cookiepp != null) {
		for (int i = 0; i < cookiepp.length; i++) {
			System.out.println(cookiepp[i].getName() + "  " + cookiepp[i].getValue());
			if (cookiepp[i].getName().equals(cookieName)) {
				ID = cookiepp[i].getValue();
				ID = URLDecoder.decode(ID, "UTF-8");
				ppt = "checked";
			}
			if (cookiepp[i].getName().equals(cookiePass)) {
				Pass = cookiepp[i].getValue();
			}
		}
		System.out.println("ID:" + ID + "    " + "Pass:" + Pass);
	}
%>
</head>
<body onload="loadHandle()">
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth">
				<div class="row w-100">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left p-5">
							<div class="brand-logo">
								<img src="../images/logo.svg">
							</div>
							<h4>你好！让我们开始吧</h4>
							<h6 class="font-weight-light">登录以继续。</h6>
							<form class="pt-3"
								action="${pageContext.request.contextPath}/Admin/pages/admin_login"
								method="post" id="subform">
								<div class="form-group">
									<input type="email" class="form-control form-control-lg"
										id="exampleInputEmail1" placeholder="用户名" name="username"
										value=<%=ID%>>
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-lg"
										id="exampleInputPassword1" placeholder="密码" name="password"
										value=<%=Pass%>>
								</div>
								<div class="mt-3">
									<a
										class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn"
										href="#"
										onclick="document.getElementById('subform').submit();">登录</a>
								</div>
								<div
									class="my-2 d-flex justify-content-between align-items-center">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input" name="checkbox"
											<%=ppt%>> 记住密码
										</label>
									</div>
									<a href="mailto:1814375626@qq.com" class="auth-link text-black" onclick="return Click5()">忘记密码?</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="../vendors/js/vendor.bundle.base.js"></script>
	<script src="../vendors/js/vendor.bundle.addons.js"></script>
	<script src="../js/off-canvas.js"></script>
	<script src="../js/misc.js"></script>
</body>
</html>