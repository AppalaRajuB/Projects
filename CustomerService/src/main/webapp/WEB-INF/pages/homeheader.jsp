<%@ page import="com.techm.beans.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Customer Service</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="robots" content="all,follow">
<!-- Bootstrap CSS-->
<link rel="stylesheet"
	href="https://d19m59y37dris4.cloudfront.net/dashboard-premium/1-4-5/vendor/bootstrap/css/bootstrap.min.css">
<!-- Font Awesome CSS-->
<link rel="stylesheet"
	href="https://d19m59y37dris4.cloudfront.net/dashboard-premium/1-4-5/vendor/font-awesome/css/font-awesome.min.css">
<!-- Fontastic Custom icon font-->
<link rel="stylesheet"
	href="https://d19m59y37dris4.cloudfront.net/dashboard-premium/1-4-5/css/fontastic.css">
<!-- Google fonts - Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700">
<!-- jQuery Circle-->
<link rel="stylesheet"
	href="https://d19m59y37dris4.cloudfront.net/dashboard-premium/1-4-5/css/grasp_mobile_progress_circle-1.0.0.min.css">
<!-- Custom Scrollbar-->
<link rel="stylesheet"
	href="https://d19m59y37dris4.cloudfront.net/dashboard-premium/1-4-5/vendor/malihu-custom-scrollbar-plugin/jquery.mCustomScrollbar.css">
<!-- theme stylesheet-->
<link rel="stylesheet"
	href="https://d19m59y37dris4.cloudfront.net/dashboard-premium/1-4-5/css/style.default.premium.css"
	id="theme-stylesheet">
<!-- Custom stylesheet - for your changes-->
<link rel="stylesheet"
	href="https://d19m59y37dris4.cloudfront.net/dashboard-premium/1-4-5/css/custom.css">
<!-- Favicon-->
<link rel="shortcut icon"
	href="https://d19m59y37dris4.cloudfront.net/dashboard-premium/1-4-5/img/favicon.ico">
<!-- Tweaks for older IEs-->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>

<body>
<%

User user = (User)session.getAttribute("userobj");
%>
	<!-- Side Navbar -->
	<nav class="side-navbar">
		<div class="side-navbar-wrapper">
			<!-- Sidebar Header    -->
			<div
				class="sidenav-header d-flex align-items-center justify-content-center">
				<!-- User Info-->
				<div class="sidenav-header-inner text-center">
					<a href="pages-profile.html"><img
						src="<%=request.getContextPath()%>/resources/images/rajuphoto3.jpg"
						alt="person" class="img-fluid rounded-circle"></a>
					<h2 class="h5"><%= user.getPersons().getName() %></h2>
					<span></span>
				</div>
				<!-- Small Brand information, appears on minimized sidebar-->
				<div class="sidenav-header-logo">
					<a href="./home" class="brand-small text-center"> <strong>C</strong><strong
						class="text-primary">S</strong></a>
				</div>
			</div>
			<!-- Sidebar Navigation Menus-->
			<div class="main-menu">
				<h5 class="sidenav-heading"></h5>
				<ul id="side-main-menu" class="side-menu list-unstyled">
					<li><a href="./home"> <i class="icon-home"></i>Home
					</a></li>
					<li><a href="./allusers" aria-expanded="false"> <i
							class="icon-form"></i>All Users
					</a></li>
					<li><a href="./personaldetails" aria-expanded="false">
							<i class="icon-form"></i>Personal Details
					</a></li>
					<li><a href="./charts" aria-expanded="false">
							<i class="fa fa-bar-chart"></i>Charts
					</a></li>

					<li><a href="./"> <i class="fa fa-sign-out"></i>Logout
					</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="page">
		<!-- navbar-->
		<header class="header">
			<nav class="navbar ">
				<div class="container-fluid">
					<div
						class="navbar-holder d-flex align-items-center justify-content-between ">
						<div class="navbar-header">
							<a id="toggle-btn" href="#" class="menu-btn"><i
								class="icon-bars"> </i></a><a href="./home" class="navbar-brand">
								<div class="brand-text d-none d-md-inline-block">
									<span style="color: red"><strong>Customer
											Service</strong></span>
								</div>
							</a>
						</div>
						<ul
							class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
							<li class="nav-item"><span><img
									src="<%=request.getContextPath()%>/resources/images/logo.jpg"
									alt="" width="" height="30px"></span></li>

							<!-- Log out-->
							<li class="nav-item"><a href="./"
								class="nav-link logout"> <span
									class="d-none d-sm-inline-block">Logout</span><i
									class="fa fa-sign-out"></i></a></li>
						</ul>
					</div>
				</div>
			</nav>
		</header>