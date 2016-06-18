<%@page import="com.utkucan.model.*"%>
<%@page import="java.util.List"%>
<%@page import="com.utkucan.dao.*"%>
<%@page import="com.utkucan.dao.impl.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	HibernateDao dao = new HibernateDaoImpl();
	List<UserModel> list = dao.getAllUser2();
	session.setAttribute("allUsers", list);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<link rel="icon" type="image/png" href="assets/img/favicon.ico">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>Kullanıcı İşlemleri</title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />


<!-- Bootstrap core CSS     -->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />

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
					<a class="navbar-brand" href="#">Kullanıcı İşlemleri</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-left">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-dashboard"></i>
						</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="fa fa-globe"></i> <b
								class="caret"></b> <span class="notification">5</span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">Notification 1</a></li>
								<li><a href="#">Notification 2</a></li>
								<li><a href="#">Notification 3</a></li>
								<li><a href="#">Notification 4</a></li>
								<li><a href="#">Another notification</a></li>
							</ul></li>
						<li><a href=""> <i class="fa fa-search"></i>
						</a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<li><a href=""> Account </a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> Dropdown <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something</a></li>
								<li class="divider"></li>
								<li><a href="#">Separated link</a></li>
							</ul></li>
						<li><a href="#"> Log out </a></li>
					</ul>
				</div>
			</div>
			</nav>


			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-8">
							<div class="card">
								<div class="content">

									<div class="container-fluid">
										<div class="row">
											<div class="col-md-12">
												<div class="card">
													<div class="header">
														<h4 class="title">Tüm Kullanıcılar</h4>
														<p class="category">Kullanıcı Bilgisi İçin Tıklayın</p>
													</div>
													<div class="content table-responsive table-full-width">
														<table id = "example" class="table table-hover table-striped" cellspacing="0" width="100%">
															<thead>
																<th>ID</th>
																<th>Ad</th>
																<th>Soyad</th>
																<th>Email</th>
																<th>Ayrıntılar</th>
															</thead>
															<tbody>
																<c:forEach items="${allUsers}" var="allUsers">
																	<tr>
																		<td>${allUsers.USER_ID}</td>
																		<td>${allUsers.USER_NAME}</td>
																		<td>${allUsers.USER_SURNAME}</td>
																		<td>${allUsers.USER_EMAIL}</td>
																		<td><a
																			href="userInformationServlet?userEmail=${allUsers.USER_EMAIL}"
																			id="sepet" class="btn btn-info btn-fill pull-left"><i
																				class="fa fa-shopping-cart"></i>Ayrıntıları</a></td>
																	</tr>
																</c:forEach>
															</tbody>
														</table>

													</div>
												</div>
											</div>


											<div class="col-md-12">
												<div class="card card-plain">
													<div class="header">
														<h4 class="title">Table on Plain Background</h4>
														<p class="category">Here is a subtitle for this table</p>
													</div>
													<div class="content table-responsive table-full-width">
														<table class="table table-hover">
															<thead>
																<th>ID</th>
																<th>Name</th>
																<th>Salary</th>
																<th>Country</th>
																<th>City</th>
															</thead>
															<tbody>
																<tr>
																	<td>1</td>
																	<td>Dakota Rice</td>
																	<td>$36,738</td>
																	<td>Niger</td>
																	<td>Oud-Turnhout</td>
																</tr>
																<tr>
																	<td>2</td>
																	<td>Minerva Hooper</td>
																	<td>$23,789</td>
																	<td>Curaçao</td>
																	<td>Sinaai-Waas</td>
																</tr>
																<tr>
																	<td>3</td>
																	<td>Sage Rodriguez</td>
																	<td>$56,142</td>
																	<td>Netherlands</td>
																	<td>Baileux</td>
																</tr>
																<tr>
																	<td>4</td>
																	<td>Philip Chaney</td>
																	<td>$38,735</td>
																	<td>Korea, South</td>
																	<td>Overland Park</td>
																</tr>
																<tr>
																	<td>5</td>
																	<td>Doris Greene</td>
																	<td>$63,542</td>
																	<td>Malawi</td>
																	<td>Feldkirchen in Kärnten</td>
																</tr>
																<tr>
																	<td>6</td>
																	<td>Mason Porter</td>
																	<td>$78,615</td>
																	<td>Chile</td>
																	<td>Gloucester</td>
																</tr>
															</tbody>
														</table>

													</div>
												</div>
											</div>


										</div>

									</div>



									<button type="submit" class="btn btn-info btn-fill pull-right">Update
										Kullanıcı İşlemleri</button>
									<div class="clearfix"></div>
									</form>
								</div>
							</div>
						</div>
						<c:if test="${not empty userInfo}">
							<div class="col-md-4">
								<div class="card card-user">
									<div class="image">
										<img
											src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400"
											alt="..." />
									</div>
									<div class="content">

										<div class="author">
											<a href="#"> <img class="avatar border-gray"
												src="assets/img/faces/face-0.jpg" alt="..." />
											</a>
										</div>
										<div class="col-md-12">
										<div class="form-group">
										<form action="userSyncServlet" method="post">
                                                <label class="">Kullanıcı ID</label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı ID" value="${userInfo.USER_ID }" name="uID">
                                                <label class="">Yetki ID</label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı Yetki ID" value="${userInfo.AUTORIZATION_ID }" name="aID">
                                                <label class="">Kullanıcı Adı </label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı İsim" value="${userInfo.USER_NAME }" name="uName">
                                                <label class="">Kullanıcı Soyadı</label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı Soyisim" value="${userInfo.USER_SURNAME }" name="uSurname">
                                                <label class="">Kullanıcı Email </label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı Email " value="${userInfo.USER_EMAIL }" name="uEmail">
                                                <label class="">Kullanıcı Şifre </label>
                                                <input type="password" class="form-control"  placeholder="Kullanıcı Şifre" value="${userInfo.USER_PASS }" name="uPass">
                                                <label class="">Kullanıcı Adres-1</label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı Adres" value="${userInfo.USER_ADDRESS }"name ="uAddress">
                                                <label class="">Kullanıcı Adres-2</label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı 2.Adres " value="${userInfo.USER_OTHER_ADDRESS }"name = "uOAddress">
                                                <label class="">Kullanıcı İletişim-1</label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı Telefon NO-1" value="${userInfo.USER_MOBILE }" name ="uMobile">
                                                <label class="">Kullanıcı İletişim-2</label>
                                                <input type="text" class="form-control"  placeholder="Kullanıcı Telefon NO-2" value="${userInfo.USER_OTHER_MOBILE }" name="uOMobile">
                                                <input type="submit" class="btn btn-info btn-fill pull-left"></input>
                                                <a href="/E-Burada/userOperationRemoveServlet"
																			id="sepet" class="btn btn-info btn-fill pull-right"><i
																				class="fa fa-shopping-cart"></i>Temizle</a>
												</form>
                                            </div>
										</div>
									</div>
								</div>
							</div>
						</c:if>

					</div>
				</div>
			</div>


			<footer class="footer">
			<div class="container-fluid">
				<nav class="pull-left">
				<ul>
					<li><a href="#"> Home </a></li>
					<li><a href="#"> Company </a></li>
					<li><a href="#"> Portfolio </a></li>
					<li><a href="#"> Blog </a></li>
				</ul>
				</nav>
				<p class="copyright pull-right">
					&copy; 2016 <a href="http://www.creative-tim.com">Creative Tim</a>,
					made with love for a better web
				</p>
			</div>
			</footer>

		</div>
	</div>


</body>

<!--   Core JS Files   -->
<script src="//code.jquery.com/jquery-1.12.3.min.js" type="text/javascript"></script>
<script src="//cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js" type="text/javascript"></script>
<script src="//cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js" type="text/javascript"></script>
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
