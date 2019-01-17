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
<link href="../css/owl.carousel.css" rel="stylesheet">
<link href="../css/responsive.css" rel="stylesheet">
<link href="../js/dl-menu/component.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="../css/bookblock.css" />
<%
	int i = 1;
	String tag1 = "登录";
	String tag2 = "注册";
	String href1="user_Login.jsp";
	String href2="user_Register.jsp";
	if (session.getAttribute("user") != null) {
		User u = (User) session.getAttribute("user");
		tag1 = u.getuName();
		tag2 = "登出";
		href1="#";
		href2="user_loginOut";
	}
%>
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
								<a href="<%=href1 %>" class="pull-left" id="xfl"><%=tag1%></a> <a
									href="<%=href2 %>" class="pull-left" id="fk"><%=tag2%></a> <a
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
										<li><a href="${pageContext.request.contextPath }/User/pages/user_myConsigness">我的收货人</a></li>
										<li><a href="blog.html">我的购物车</a></li>
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
		<div class="kode-banner">
			<ul class="bxslider">
				<li><img src="../images/banner-1.png" alt="">
					<div class="kode-caption-2">
						<h5>你在找书吗？</h5>
						<h2>现代美文</h2>
						<p>相遇就是缘分，相处就是续缘，相知就是惜缘。爱的路上，没有早晚，也没有长短，只有是否珍惜。惊鸿一瞥的回眸，让心从此跟你走，无论朝朝暮暮，寒风酷暑；莞尔一笑的笑颜，让爱从此有了归属，无论人情冷暖，是风是雨。</p>
						<div class="caption-btns">
							<a
								href="${pageContext.request.contextPath }/User/pages/user_allBook?pages=1">查看书籍</a>
							<a
								href="${pageContext.request.contextPath }/User/pages/user_allAuthor?pages=1">了解作者</a>
						</div>
					</div></li>
				<li><img src="../images/banner-2.png" alt="">
					<div class="kode-caption-2">
						<h5>你在找书吗</h5>
						<h2>随心而动</h2>
						<p>曾经沧海难为水，除却巫山不是云。取次花丛懒回顾，半缘修道半缘君。</p>
						<div class="caption-btns">
							<a
								href="${pageContext.request.contextPath }/User/pages/user_allBook?pages=1">查看书籍</a>
							<a
								href="${pageContext.request.contextPath }/User/pages/user_allAuthor?pages=1">了解作者</a>
						</div>
					</div></li>
				<li><img src="../images/banner-3.png" alt="">
					<div class="kode-caption-2">
						<h5>你在找书吗？</h5>
						<h2>古典文学</h2>
						<p>昨夜雨疏风骤，浓睡不消残酒。试问卷帘人，却道海棠依旧。知否？知否？应是绿肥红瘦。</p>
						<div class="caption-btns">
							<a
								href="${pageContext.request.contextPath }/User/pages/user_allBook?pages=1">查看书籍</a>
							<a
								href="${pageContext.request.contextPath }/User/pages/user_allAuthor?pages=1">了解作者</a>
						</div>
					</div></li>
			</ul>
		</div>
		<!--BANNER END-->
		<!--BUT NOW START-->
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

				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="Basic">
						<div class="form-container">
							<div class="row">
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="书名">
								</div>
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="作者">
								</div>
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="类型">
								</div>
								<div class="col-md-3 col-sm-12">
									<button>搜索</button>
								</div>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="Author">
						<div class="form-container">
							<div class="row">
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="书名">
								</div>
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="作者">
								</div>
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="类型">
								</div>
								<div class="col-md-3 col-sm-12">
									<button>搜索</button>
								</div>
							</div>
						</div>
					</div>
					<div role="tabpanel" class="tab-pane" id="Publications">
						<div class="form-container">
							<div class="row">
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="书名">
								</div>
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="作者">
								</div>
								<div class="col-md-3 col-sm-4">
									<input type="text" placeholder="类型">
								</div>
								<div class="col-md-3 col-sm-12">
									<button>搜索</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--BUT NOW END-->
		<!--CONTENT START-->
		<section class="lib-papular-books">
		<div class="container">
			<!--SECTION CONTENT START-->
			<div class="section-heading-1">
				<h2>最畅销书籍</h2>
				<p>最畅销的图书可以在书库中找到</p>
				<div class="kode-icon">
					<i class="fa fa-book"></i>
				</div>
			</div>
			<div class="row">
				<!--SECTION CONTENT END-->
				<ul class="nav nav-tabs" role="tablist">
					<c:forEach items="${booklist }" var="gb">
						<li role="presentation" class="col-md-4 col-sm-3"><a
							href="#book${gb.bid }" role="tab" data-toggle="tab">
								<div class="lib-papular-thumb">
									<img src="${pageContext.request.contextPath}/${gb.bPhoto}"
										alt="书本图片" width="155px" height="194px">
								</div>
						</a></li>
					</c:forEach>
				</ul>
				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active"
						id="book${booklist[0].bid }">
						<div class="lib-papular">
							<div class="kode-thumb">
								<img
									src="${pageContext.request.contextPath}/${booklist[0].bPhoto}"
									alt="" style="width: 247px; height: 418px" />
							</div>
							<div class="kode-text">
								<h2>${booklist[0].bName }</h2>
								<h4>${booklist[0].autName }</h4>
								<div class="rating">
									<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
								</div>
								<p>${booklist[0].bdetail }</p>
								<div class="lib-price">
									<h3>￥${booklist[0].bPrice }</h3>
									<a href="#">立即购买</a>
								</div>
							</div>
						</div>
					</div>
					<c:forEach items="${booklist }" var="gb">
						<div role="tabpanel" class="tab-pane fade" id="book${gb.bid }">
							<div class="lib-papular">
								<div class="kode-thumb">
									<img src="${pageContext.request.contextPath}/${gb.bPhoto}"
										alt="" style="width: 247px; height: 418px" />
								</div>
								<div class="kode-text">
									<h2>${gb.bName }</h2>
									<h4>${gb.autName }</h4>
									<div class="rating">
										<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
									</div>
									<p>${gb.bdetail }</p>
									<div class="lib-price">
										<h3>￥${gb.bPrice }</h3>
										<a href="#">立即购买</a>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		</section>
		<div class="kode-content">

			<!--BOOK GUIDE SECTION START-->
			<section class="lib-categories-section">
			<div class="container">
				<!--SECTION CONTENT START-->
				<div class="section-heading-1 dark-sec">
					<h2>我们的热门类别</h2>
					<p>以下是本店的一些顶级类别</p>
					<div class="kode-icon">
						<i class="fa fa-book"></i>
					</div>
				</div>
				<!--SECTION CONTENT END-->
				<ul class="nav nav-tabs" role="tablist">
					<c:forEach items="${stortlist }" var="stl">
						<li role="presentation"><a href="#Stort${stl.stid }"
							role="tab" data-toggle="tab">${stl.stName }</a></li>
					</c:forEach>
				</ul>
				<!-- Tab panes -->
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane fade in active"
						id="Stort${stortlist[0].stid }">
						<ul class="bxslider">
							<li><c:forEach items="${showStort1 }" var="ss1">
									<div class="col-md-3 col-sm-6 best-seller-pro">
										<figure> <img
											src="${pageContext.request.contextPath }/${ss1.bPhoto }"
											style="width: 211px; height: 314px" alt=""> </figure>
										<div class="kode-text">
											<h3>${ss1.bName }</h3>
										</div>
										<div class="kode-caption">
											<h3>${ss1.bName }</h3>
											<div class="rating">
												<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
											</div>
											<p>${ss1.autName  }</p>
											<p class="price">￥${ss1.bPrice }</p>
											<a href="#" class="add-to-cart">加入购物车</a>
										</div>
									</div>
								</c:forEach></li>
						</ul>
					</div>
					<div role="tabpanel" class="tab-pane fade"
						id="Stort${stortlist[1].stid }">
						<ul class="bxslider-1">
							<li><c:forEach items="${showStort2 }" var="ss2">
									<!--PRODUCT GRID START-->
									<div class="col-md-3 col-sm-6 best-seller-pro">
										<figure> <img
											src="${pageContext.request.contextPath }/${ss2.bPhoto }"
											style="width: 211px; height: 314px" alt=""> </figure>
										<div class="kode-text">
											<h3>${ss2.bName }</h3>
										</div>
										<div class="kode-caption">
											<h3>${ss2.bName }</h3>
											<div class="rating">
												<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
											</div>
											<p>${ss2.autName }</p>
											<p class="price">${ss2.bPrice }</p>
											<a href="#" class="add-to-cart">加入购物车</a>
										</div>
									</div>
								</c:forEach></li>
						</ul>
					</div>
					<div role="tabpanel" class="tab-pane fade"
						id="Stort${stortlist[2].stid }">
						<ul class="bxslider-3">
							<li><c:forEach items="${showStort3 }" var="ss3">
									<!--PRODUCT GRID START-->
									<div class="col-md-3 col-sm-6 best-seller-pro">
										<figure> <img
											src="${pageContext.request.contextPath }/${ss3.bPhoto }"
											style="width: 211px; height: 314px" alt=""> </figure>
										<div class="kode-text">
											<h3>${ss3.bName }</h3>
										</div>
										<div class="kode-caption">
											<h3>${ss3.bName }</h3>
											<div class="rating">
												<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
											</div>
											<p>${ss3.autName }</p>
											<p class="price">￥${ss3.bPrice }</p>
											<a href="#" class="add-to-cart">加入购物车</a>
										</div>
									</div>
								</c:forEach></li>
						</ul>
					</div>
					<div role="tabpanel" class="tab-pane fade"
						id="Stort${stortlist[3].stid }">
						<ul class="bxslider-4">
							<li><c:forEach items="${showStort4 }" var="ss4">
									<!--PRODUCT GRID START-->
									<div class="col-md-3 col-sm-6 best-seller-pro">
										<figure> <img
											src="${pageContext.request.contextPath }/${ss4.bPhoto }"
											style="width: 211px; height: 314px" alt=""> </figure>
										<div class="kode-text">
											<h3>${ss4.bName }</h3>
										</div>
										<div class="kode-caption">
											<h3>${ss4.bName }</h3>
											<div class="rating">
												<span>☆</span><span>☆</span><span>☆</span><span>☆</span><span>☆</span>
											</div>
											<p>${ss4.autName }</p>
											<p class="price">￥${ss4.bPrice }</p>
											<a href="#" class="add-to-cart">加入购物车</a>
										</div>
									</div>
									<!--PRODUCT GRID END-->
									<!--PRODUCT GRID START-->
								</c:forEach></li>
						</ul>
					</div>
				</div>
			</div>
			</section>
			<!--TOP SELLERS SECTION END-->
			<section>
			<div class="container">
				<div class="section-heading-1">
					<h2>精品美文欣赏(部分章节)</h2>
					<p>该书本可以在书库中找到</p>
					<div class="kode-icon">
						<i class="fa fa-book"></i>
					</div>
				</div>
				<div class="bb-custom-wrapper">
					<div id="bb-bookblock" class="bb-bookblock">
						<c:forEach items="${noteslist }" var="notes">
							<div class="bb-item">
								<div class="bb-custom-side">
									<h3>
										美文<%=i++%>
									</h3>
									<p>${notes.article1 }</p>
								</div>
								<div class="bb-custom-side">
									<h3>
										美文<%=i++%>
									</h3>
									<p>${notes.article2 }</p>
								</div>
							</div>
						</c:forEach>
					</div>
					<nav> <a id="bb-nav-prev" href="#"
						class="bb-custom-icon bb-custom-icon-arrow-left">Previous</a> <a
						id="bb-nav-next" href="#"
						class="bb-custom-icon bb-custom-icon-arrow-right">Next</a> </nav>
				</div>
			</div>
			</section>
			<!--VIDEO SECTION START-->
			<!--VIDEO SECTION END-->
			<!--BEST SELLER SLIDER SECTION START-->

		</div>
		<!--CONTENT END-->
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
	</div>
	<!--WRAPPER END-->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="../js/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="../js/modernizr.custom.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script src="../js/jquery.bxslider.min.js"></script>
	<script src="../js/bootstrap-slider.js"></script>
	<script src="../js/waypoints.min.js"></script>
	<script src="../js/jquery.counterup.min.js"></script>
	<script src="../js/owl.carousel.js"></script>
	<script src="../js/dl-menu/jquery.dlmenu.js"></script>
	<script type="text/javascript" src="../lib/hash.js"></script>
	<script type="text/javascript" src="../lib/booklet-lib.js"></script>
	<script src="../js/jquerypp.custom.js"></script>
	<script src="../js/jquery.bookblock.js"></script>
	<script src="../js/functions.js"></script>
</body>
</html>