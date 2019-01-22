<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>添加管理员</title>
<link rel="stylesheet"
	href="../vendors/iconfonts/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="../vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" href="../css/style.css">
<link rel="shortcut icon" href="../images/favicon.png" />
</head>
<%
if(request.getAttribute("addIsOk")!=null){
	int isOk=(int)request.getAttribute("addIsOk");
	if(isOk==0){
%>
<script type="text/javascript">
alert("用户名已存在，请重新输入！");
</script>
<%
	}else{
%>
<script type="text/javascript">
alert("添加成功！");
</script>
<%
	}
}
%>
<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth">
				<div class="row w-100">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left p-5">
							<div class="brand-logo">
								<img src="../images/logo.svg">
							</div>
							<h4>添加管理员</h4>
							<h6 class="font-weight-light">添加很容易,它只需要简单的几个步骤</h6>
							<form class="pt-3" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/Admin/pages/admin_adminUpload" id="subform">
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputUsername1" placeholder="用户名" name="bookName">
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-lg"
										id="exampleInputEmail1" placeholder="联系电话" name="admTel">
								</div>
								<div class="form-group">
									<input type="file" name="bookUp" class="file-upload-default">
									<div class="input-group col-xs-12">
										<input type="text" class="form-control file-upload-info"
											disabled placeholder="头像"> <span
											class="input-group-append">
											<button class="file-upload-browse btn btn-gradient-primary"
												type="button">浏览</button>
										</span>
									</div>
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-lg"
										id="exampleInputPassword1" placeholder="密码" name="admPass">
								</div>
								<div class="mt-3">
									<a
										class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn"
										href="#" onclick="document.getElementById('subform').submit();">确认</a>
								</div>
								<br />
								<div class="mt-3">
									<a
										class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn"
										href="${pageContext.request.contextPath}/Admin/pages/admin_statistical">返回</a>
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
	<script src="../js/file-upload.js"></script>
	<script src="../js/off-canvas.js"></script>
	<script src="../js/misc.js"></script>
</body>
</html>