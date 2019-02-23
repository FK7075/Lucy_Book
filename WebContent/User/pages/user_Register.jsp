<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>User_Lucy_Book</title>
<link rel="icon" href="3.ico" type="image/x-icon" />
<link rel="stylesheet" href="../css/reset.css" />
<link rel="stylesheet" href="../css/common.css" />
<link rel="stylesheet" href="../css/font-awesome.min.css" />
<%
	if (request.getAttribute("isOK") != null) {
		int isOK = (int) request.getAttribute("isOK");
		if (isOK == 1) {
%>
<script type="text/javascript">
	alert("用户名已存在，请重新输入！");
</script>
<%
	}
		if (isOK == 0) {
%>
<script type="text/javascript">
	alert("注册成功！");
</script>
<%
	}
	}
%>
<script type="text/javascript">
	function click1() {
		if (document.getElementById("Uname") == ""
				|| document.getElementById("Tel") == ""
				|| document.getElementById("uPass") == ""
				|| document.getElementById("uPass1")==""){
			alert("您的注册信息似乎没有填写完整！");
		}else if(document.getElementById("uPass").value != document
				.getElementById("uPass1").value){
			alert("两次输入的密码不一致，请重新输入！");
		}else{
			document.getElementById('subform').submit();
		}
	}
</script>
</head>
<body>
	<div class="wrap login_wrap">
		<div class="content">

			<div class="logo"></div>

			<div class="login_box">

				<div class="login_form">
					<div class="login_title">注册</div>
					<form
						action="${pageContext.request.contextPath }/User/pages/user_register"
						method="post" id="subform">

						<div class="form_text_ipt">
							<input name="uName" type="text" placeholder="用户名" id="Uname">
						</div>
						<div class="ececk_warning">
							<span>用户名不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="uTel" type="text" placeholder="手机号" id="Tel">
						</div>
						<div class="ececk_warning">
							<span>手机号不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="uPass" type="password" placeholder="密码" id="uPass">
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="uPass1" type="password" placeholder="重复密码"
								id="uPass1">
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>

						<div class="form_btn">
							<button type="button" onclick="click1();">注册</button>
						</div>
						<div class="form_reg_btn">
							<span>已有帐号？</span><a href="user_Login.jsp">马上登录</a>
						</div>
					</form>
					<div class="other_login">
						<div class="left other_left">
							<a
								href="${pageContext.request.contextPath }/User/pages/user_homeContent">返回书店主页</a>
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