<%@page import="com.utkucan.model.*"%>
<%@page import="java.util.List"%>
<%@page import="com.utkucan.dao.*"%>
<%@page import="com.utkucan.dao.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%	UserModel user = (UserModel) session.getAttribute("user");
	HibernateDao dao = new HibernateDaoImpl();
	List<SubCategoryModel> list = dao.findAll(SubCategoryModel.class);
	List<MainCategoryModel> list2 = dao.findAll(MainCategoryModel.class);
	List<SuperCategoryModel> list3 = dao.findAll(SuperCategoryModel.class);
	List<ProductModel> list4 = dao.findAll(ProductModel.class);
	session.setAttribute("allCategories", list);
	session.setAttribute("allCategories2", list2);
	session.setAttribute("allCategories3", list3);
	request.setAttribute("allProducts", list4);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Gifty Alışveriş</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="application/x-javascript">
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<link href="Bootstrap/css/bootstrap.css" rel='stylesheet'
	type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="Bootstrap/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="Bootstrap/css/jquery.countdown.css" />
<!-- Custom Theme files -->
<!--webfont-->
<link
	href='http://fonts.googleapis.com/css?family=Raleway:100,200,300,400,500,600,700,800,900'
	rel='stylesheet' type='text/css'>
<script type="text/javascript" src="Bootstrap/js/jquery-1.11.1.min.js"></script>
<!-- dropdown -->
<script src="Bootstrap/js/jquery.easydropdown.js"></script>
<!-- start menu -->
<link href="Bootstrap/css/megamenu.css" rel="stylesheet" type="text/css"
	media="all" />
<script type="text/javascript" src="Bootstrap/js/megamenu.js"></script>
<script>
	$(document).ready(function() {
		$(".megamenu").megamenu();
	});
</script>
<script src="Bootstrap/js/responsiveslides.min.js"></script>
<script>
	$(function() {
		$("#slider").responsiveSlides({
			auto : true,
			nav : false,
			speed : 500,
			namespace : "callbacks",
			pager : true,
		});
	});
</script>
<script src="Bootstrap/js/jquery.countdown.js"></script>
<script src="Bootstrap/js/script.js"></script>
</head>
<body>
	<div class="header_top">
		<div class="container">
			<div class="header_top-box">
				<div class="header-top-left">
					<div class="clearfix"></div>
				</div>
				<div class="cssmenu">
					<ul>
						<c:if test="${not empty user}">
							<li class="active"><a href="login.html">${user.USER_NAME}
									${user.USER_SURNAME}</a></li>
							<li><a href="Sepet.jsp">${user.USER_NAME}'nun Sepeti</a></li>
							<li><a href="Logout">Çıkış Yap</a></li>
						</c:if>
						<c:if test="${empty user}">
							<li><a href="login.jsp">Giriş Yap</a></li>
							<li><a href="register.jsp">Kayıt Ol</a></li>
						</c:if>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="header_bottom">
		<div class="container">
			<div class="header_bottom-box">
				<div class="header_bottom_left">
					<div class="logo">
						<a href="index.html"><img src="Bootstrap/images/logo.png"
							alt="" /></a>
					</div>
					<ul class="clock">
						<i class="clock_icon"> </i>
						<li class="clock_desc">7/24 Hizmet</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="header_bottom_right">
					<div class="search">
						<input type="text" value="Your email address"
							onfocus="this.value = '';"
							onblur="if (this.value == '') {this.value = 'Your email address';}">
						<input type="submit" value="">
					</div>
					<ul class="bag">
						<a href="#"><i class="bag_left"> </i></a>
						<a href="#"><li class="bag_right"><p>205.00 $</p></li></a>
						<div class="clearfix"></div>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<div class="menu">
		<div class="container">
			<div class="menu_box">
				<ul class="megamenu skyblue">
					<li class="active grid"><a class="color2" href="index.html">Home</a></li>
					<% for(int i = 0; i < list3.size(); i++){ %>
						<li><a class="color10" href="#"><%=list3.get(i).getCategoryName() %></a>
							<div class="megapanel">
								<div class="row">
									<div class="col1">
										<div class="h_nav">
										<%
										List<MainCategoryModel> mains = dao.getCategoryById(list3.get(i).getCategoryId());
										%>
										<% for(int j = 0; j < mains.size(); j++){ %>
											<h4><%=mains.get(j).getMainCategoryName()%></h4>
											<%
										List<SubCategoryModel> mains2 = dao.getSubCategoryById(mains.get(j).getMainCategoryId());
										%>
											<% for(int k = 0; k < mains2.size(); k++){ %>
												<ul>
												<li><a><%=mains2.get(k).getSubCategoryName()%></a></li>
											</ul>
											<%}%>
									<%}%>
										</div>
									</div>
								</div>
							</div></li>
 						<%}%>


				</ul>
			</div>
		</div>
	</div>
	<div class="index_slider">
		<div class="container">
			<div class="callbacks_container">
				<ul class="rslides" id="slider">
					<li><img src="Bootstrap/images/slider1.jpg"
						class="img-responsive" alt="" /></li>
					<li><img src="Bootstrap/images/2.jpg" class="img-responsive"
						alt="" /></li>
					<li><img src="Bootstrap/images/3.jpg" class="img-responsive"
						alt="" /></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="content_top">
		<div class="container">
			<div class="grid_1">
				<div class="col-md-3">
					<div class="box2">
						<ul class="list1">
							<i class="lock"> </i>
							<li class="list1_right"><p>Sepette Süpriz iNdirimler</p></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="box3">
						<ul class="list1">
							<i class="clock1"> </i>
							<li class="list1_right"><p>Geri İade İmkanı</p></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="box4">
						<ul class="list1">
							<i class="vehicle"> </i>
							<li class="list1_right"><p>100 Tl Üzeri Alışverişlerde
									Ücretsiz Kargo</p></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div class="col-md-3">
					<div class="box5">
						<ul class="list1">
							<i class="dollar"> </i>
							<li class="list1_right"><p>Müşteri Memnuniyeti</p></li>
							<div class="clearfix"></div>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<div class="column_center">
				<h1>1 of the most Beautiful online store</h1>
				<h2>Clothes is one of the word'd leading E-commerce companies
					that designs and develops online stores</h2>
			</div>
			<div class="sellers_grid">
				<ul class="sellers">
					<i class="star"> </i>
					<li class="sellers_desc"><h2>Best Sellers</h2></li>
					<div class="clearfix"></div>
				</ul>
			</div>
			<div class="grid_2">
				<c:forEach items="${allProducts}" var="a">
					<div class="col-md-3 span_6">
						<div class="box_inner">
							<img class="img-thumbnail" style="width: 320px; height: 150px;"
								src="<c:url value="/resimgetir?mresim=${a.IMAGE_RESOURCE} "/>" />
							<div class="sale-box"></div>
							<div class="desc">
								<h3>${a.PRODUCT_NAME}</h3>
								<h4>${a.PRICE}$</h4>
								<h5>${a.PRODUCT_INFO}</h5>
								<ul class="list2">
									<li class=""><span class="m_1">
									<a href="SepeteEkle?ID=${a.PRODUCT_ID}" class="link">Sepete Ekle</a></span></li>
								</ul>
								<div class="heart"></div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
</body>
</html>
