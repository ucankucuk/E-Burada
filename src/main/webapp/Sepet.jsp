<%@page import="com.utkucan.model.*"%>
<%@page import="java.util.List"%>
<%@page import="com.utkucan.dao.*"%>
<%@page import="com.utkucan.dao.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
HibernateDao dao = new HibernateDaoImpl();
List<SubCategoryModel> list = dao.findAll(SubCategoryModel.class);
List<MainCategoryModel> list2 = dao.findAll(MainCategoryModel.class);
List<SuperCategoryModel> list3 = dao.findAll(SuperCategoryModel.class);
List<ProductModel> list4 = (List<ProductModel>)session.getAttribute("sepet");
request.setAttribute("allCategories", list);
request.setAttribute("allCategories2", list2);
request.setAttribute("allCategories3", list3);
request.setAttribute("allProducts", list4);
%>
<!DOCTYPE HTML>
<html>
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
							<li><a href="/E-Burada/Logout">Çıkış Yap</a></li>
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
<div class="men">
	<div class="container">
	    <div class="wishlist">
		  	  <h4 class="title">Shopping cart is empty</h4>
		  	  <div class="card">
								<div class="header">
									<h4 class="title">Edit Profile</h4>
									<p class="category">Güncelleme İşlemi İçin Ayrıntılara
										Tıklayın</p>
								</div>
								<div class="content table-responsive table-full-width">
									<table class="footable table table-bordered toggle-circle">
										<thead>

											<tr>
												<th>Katagorisi</th>
												<th>Adı</th>
												<th>Açıklaması</th>
												<th>Birim Fiyatı</th>
												<th>Resim</th>
											</tr>
										</thead>
										<tbody>

											<c:forEach items="${allProducts}" var="a">
												<tr>
													<td>${a.subCategoryId.subCategoryName}</td>
													<td>${a.PRODUCT_NAME}</td>
													<td>${a.PRODUCT_INFO}</td>
													<td>${a.PRICE}</td>
													<td><img class="img-thumbnail" style="width: 320px; height: 150px;" src="<c:url value="/resimgetir?mresim=${a.IMAGE_RESOURCE} "/>" /></td>
											</c:forEach>
											<tr>
										</tbody>

										<tfoot>
											<tr>
												<td colspan="10">
													<div
														class="pagination pagination-centered hide-if-no-paging"></div>
												</td>
											</tr>
										</tfoot>
									</table>

								</div>
							</div>
							<a href="SiparisTamamla" class="btn btn-success"> Sipariş Tamamla</a>
		 </div>
	 </div>
</div>
<div class="footer">
	<div class="container">
		<ul class="footer_nav">
		  <li><a href="#">Home</a></li>
		  <li><a href="#">Blog</a></li>
		  <li><a href="#">Shop</a></li>
		  <li><a href="#">Media</a></li>
		  <li><a href="#">Features</a></li>
		  <li><a href="#">About Us</a></li>
		  <li><a href="contact.html">Contact Us</a></li>
		</ul>
		<p class="copy">Copyright&copy; 2015 Template by <a href="http://w3layouts.com" target="_blank"> w3layouts</a></p>
	</div>
</div>
</body>
</html>		