<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>User_Lucy_Book</title>
<link rel="stylesheet" href="../css/reset.css" />
<link rel="stylesheet" href="../css/common.css" />
<link rel="stylesheet" href="../css/font-awesome.min.css" />
<%
	if (request.getAttribute("isOk") != null) {
%>
<script type="text/javascript">
	alert("用户名与密码不匹配！")
</script>
<%
	}
%>
</head>
<body>
	<div class="wrap login_wrap">
		<div class="content">
			<div class="logo"></div>
			<div class="login_box">

				<div class="login_form">
					<div class="login_title">登录</div>
					<form
						action="${pageContext.request.contextPath }/User/pages/user_login"
						method="post" id="subform">

						<div class="form_text_ipt">
							<input name="uName" type="text" placeholder="用户名">
						</div>
						<div class="ececk_warning">
							<span>用户名不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="uPass" type="password" placeholder="密码">
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>
						<div class="form_check_ipt">
							<div class="left check_left">
								<label><input name="" type="checkbox"> 记住密码</label>
							</div>
						</div>
						<div class="form_btn">
							<button type="button"
								onclick="document.getElementById('subform').submit();">登录</button>
						</div>
						<div class="form_reg_btn">
							<span>还没有帐号？</span><a href="user_Register.jsp">马上注册</a>
						</div>
					</form>
					<div class="other_login">
						<div class="left other_left">
							<a href="${pageContext.request.contextPath }/User/pages/user_homeContent">返回书店主页</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/common.js"></script>
	<div style="text-align: center;"></div>
</body>
</html>