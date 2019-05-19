<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Customer Service</title>
<jsp:include page="../pages/header.jsp" />
<style>
table {
	border: 1px solid black;
}
</style>

</head>
<body>
	<div class="container">
		<table style="width:100%;">
			<tr>
				<td width="33%" align="left"><img
					src="<%=request.getContextPath()%>/resources/images/sidecut.png"
					alt="" width="100%" height="18%"></td>
				<td width="33%" align="center">
					<h2 style="color: red">Customer Service</h2>
				</td>
				<td width="33%" align="right"><img
					src="<%=request.getContextPath()%>/resources/images/logo.jpg"
					alt="" width="" height="35%"></td>
			</tr>
		</table>
		<table style="width:100%;">
			<tr>
				<td width="50%">
					<div id="demo" class="carousel slide" data-ride="carousel">
						<!-- Indicators -->
						<ul class="carousel-indicators">
							<li data-target="#demo" data-slide-to="0" class="active"></li>
							<li data-target="#demo" data-slide-to="1"></li>
							<li data-target="#demo" data-slide-to="2"></li>
						</ul>
						<!-- The slideshow -->
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img
									src="<%=request.getContextPath()%>/resources/images/image11.jpg"
									alt="" width="100%" height="200%">
							</div>
							<div class="carousel-item">
								<img
									src="<%=request.getContextPath()%>/resources/images/image11.jpg"
									alt="" width="100%" height="100%">
							</div>
							<div class="carousel-item">
								<img
									src="<%=request.getContextPath()%>/resources/images/image11.jpg"
									alt="" width="100%" height="100%">
							</div>
						</div>
						<!-- Left and right controls -->
						<a class="carousel-control-prev" href="#demo" data-slide="prev">
							<span class="carousel-control-prev-icon"></span>
						</a> <a class="carousel-control-next" href="#demo" data-slide="next">
							<span class="carousel-control-next-icon"></span>
						</a>
					</div>
				<td>
				<td width="50%">
					<div class=" " align="center">
						<img
							src="<%=request.getContextPath()%>/resources/images/avatarlogin.png"
							class="rounded-circle" style="width: 70px;">
					</div>
					<div class="card">
						<div class="card-body" style="height: 100">
							<div class="form-group">
								<form:form action="./login" modelAttribute="user">
								<div id="errorMsg" style="color:red">${nouser}</div><br>
									<div class="form-group">
										<label for="email">Email address:</label>
										<form:input type="email" class="form-control" id="email"
											path="email" placeholder="Enter email" />
									</div>
									<div class="form-group">
										<label for="pwd">Password:</label>
										<form:input type="password" class="form-control" id="pwd"
											path="passwd" placeholder="Enter Password" />
									</div>
									<div class="form-group" align="right">
										<a href="./register"> <u>Register</u>
										</a>
									</div>
									<div class="form-group " align="center">
										<input type="submit" class="btn btn-primary" value="  Login "></input>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<BR> <BR> <BR>
		<div align="center">
			<span class="copyright" style="color: gray"> &copy; 2019 Tech
				Mahindra Ltd. All rights reserved.</span>
		</div>
	</div>
	<jsp:include page="../pages/footer.jsp" />
</body>