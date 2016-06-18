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
	session.setAttribute("allCategories", list);
	session.setAttribute("allCategories2", list2);
	session.setAttribute("allCategories3", list3);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Kargo İşlemleri</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<link
	href="//cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css"
	rel="stylesheet" />

<!-- Animation library for notifications   -->
<link href="assets/css/animate.min.css" rel="stylesheet" />

<!--  Light Bootstrap Table core CSS    -->
<link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet" />


<!--  CSS for Demo Purpose, don't include it in your project     -->
<link href="assets/css/demo.css" rel="stylesheet" />


<!--     Fonts and icons     -->
<link
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'
	rel='stylesheet' type='text/css'>
<link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet" />
</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-color="blue"
			data-image="assets/img/sidebar-4.jpg">

			<!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="admin.jsp" class="simple-text"> E-Burada.com </a>
				</div>

				<ul class="nav">
										<li><a href="cargo.jsp"> <i class="pe-7s-users"></i>
							<p>Kargo İşlemleri</p>
					</a></li>
					<li><a href="category.jsp"> <i class="pe-7s-credit"></i>
							<p>Kategori İşlemleri</p>
					</a></li>
					<li><a href="Product.jsp"> <i class="pe-7s-shopbag"></i>
							<p>Ürün İşlemleri</p>
					</a></li>
					<li class="active"><a href="Siparisler.jsp"> <i
							class="pe-7s-car"></i>
							<p>Sipariş İşlemleri</p><span id="siparisNo"></span>
					</a></li>
					<li class="active"><a href="userOperation.jsp"> <i
							class="pe-7s-car"></i>
							<p>Üye İşlemleri</p><span id="siparisNo"></span>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default navbar-fixed">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#navigation-example-2">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Kategori İşlemleri</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#"> Log out </a></li>
					</ul>
				</div>
			</div>
			</nav>

			<div class="content">
				<div class="container-fluid">
					<div class="row">

						<div class="col-md-5">
							<div class="card">
								<div class="header">
									<h4 class="title">Üst Kategori Ekle</h4>
								</div>
								<div class="content">
									<form action="CategoryAddServlet" method="post">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Kategori Adı</label> <input type="text"
														class="form-control" name="ad">
												</div>
											</div>
										</div>
										<button type="submit" class="btn btn-danger btn-block">
											<b>Kargo Ekle</b>
										</button>
										<div class="clearfix"></div>

									</form>
								</div>
							</div>
						</div>

						<div class="col-md-7">
							<div class="card">
								<div class="header">
									<h4 class="title">Edit Profile</h4>
									<p class="category">Güncelleme İşlemi İçin Ayrıntılara
										Tıklayın</p>
								</div>
								<div class="content table-responsive table-full-width">
									<table id="example" class="table table-striped table-bordered"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>ID</th>
												<th>Süper Kategori Adı</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allCategories3}" var="a">
												<tr>
													<td>${a.categoryId}</td>
													<td>${a.categoryName}</td>
											</c:forEach>
										</tbody>
									</table>

								</div>
							</div>
						</div>

						<div class="col-md-5">
							<div class="card">
								<div class="header">
									<h4 class="title">Kargo Firması Ekle</h4>
									<p class="category">Firma Ekleme İşlemi İçin Bilgileri
										Doldurun</p>
								</div>
								<div class="content">
									<form action="AddMainCategoryServlet" method="post">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-lg-3 control-label">Ürünün
														Katagorisi</label>
													<div class="col-lg-8">
														<select title="Katagori Seçiniz" class="form-control"
															name="id">
															<option value="">Katagori Seçiniz</option>
															<c:forEach items="${allCategories3}" var="a">
																<option value="${a.categoryId}">${a.categoryName}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-lg-4 control-label">Kargo Adı</label> <input type="text"
														class="form-control" name="ad">
												</div>
											</div>
										</div>
										<button type="submit" class="btn btn-danger btn-block">
											<b>Kargo Ekle</b>
										</button>
										<div class="clearfix"></div>

									</form>
								</div>
							</div>
						</div>
						<div class="col-md-7">
							<div class="card">
								<div class="header">
									<h4 class="title">Edit Profile</h4>
									<p class="category">Güncelleme İşlemi İçin Ayrıntılara
										Tıklayın</p>
								</div>
								<div class="content table-responsive table-full-width">
									<table id="example" class="table table-striped table-bordered"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>ID</th>
												<th>Süper Kategori Adı</th>
												<th>Orta Kategori Adı</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allCategories2}" var="a">
												<tr>
													<td>${a.mainCategoryId}</td>
													<td>${a.getSuperCategoryId().getCategoryName()}</td>
													<td>${a.mainCategoryName}</td>
											</c:forEach>
										</tbody>
									</table>

								</div>
							</div>
						</div>
	<div class="col-md-12">
						<div class="col-md-5">
							<div class="card">
								<div class="header">
									<h4 class="title">Kargo Firması Ekle</h4>
									<p class="category">Firma Ekleme İşlemi İçin Bilgileri
										Doldurun</p>
								</div>
								<div class="content">
									<form action="SubCategoryModel" method="post">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="col-lg-3 control-label">Ürünün
														Katagorisi</label>
													<div class="col-lg-5">
														<select title="Katagori Seçiniz" class="form-control"
															name="id">
															<option value="">Katagori Seçiniz</option>
															<c:forEach items="${allCategories2}" var="a">
																<option value="${a.mainCategoryId}">${a.mainCategoryName}</option>
															</c:forEach>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label>Kargo Adı</label> <input type="text"
														class="form-control" name="ad">
												</div>
											</div>
										</div>
										<button type="submit" class="btn btn-danger btn-block">
											<b>Kargo Ekle</b>
										</button>
										<div class="clearfix"></div>

									</form>
								</div>
							</div>
						</div>



						<div class="col-md-6">
							<div class="card">
								<div class="header">
									<h4 class="title">Edit Profile</h4>
									<p class="category">Güncelleme İşlemi İçin Ayrıntılara
										Tıklayın</p>
								</div>
								<div class="content table-responsive table-full-width">
									<table id="example" class="table table-striped table-bordered"
										cellspacing="0" width="100%">
										<thead>
											<tr>
												<th>ID</th>
												<th>Orta Kategori Adı</th>
												<th>Alt Kategori Adı</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${allCategories}" var="a">
												<tr>
													<td>${a.subCategoryId}</td>
													<td>${a.mainCategoryId.mainCategoryName}</td>
													<td>${a.subCategoryName}</td>
											</c:forEach>
										</tbody>
									</table>

								</div>
							</div>
						</div>

</div>
					</div>
				</div>
			</div>
</body>

<!--   Core JS Files   -->
<script src="//code.jquery.com/jquery-1.12.3.min.js"
	type="text/javascript"></script>
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script
	src="//cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"
	type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

<!--  Checkbox, Radio & Switch Plugins -->
<script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!--  Google Maps Plugin    -->
<script type="text/javascript"
	src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

<!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
<script src="assets/js/light-bootstrap-dashboard.js"></script>

<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
<script src="assets/js/demo.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>

</html>
