<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register</title>
<jsp:include page="../pages/header.jsp" />
<style>
.borders {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div class="container">
		<table style="width:100%;" class="borders">
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
		<table  style="width:100%;" background="<%=request.getContextPath()%>/resources/images/bgimage.jpg"
			class="borders">
			<tr>
				<td>&nbsp; <br>
				<td>
			</tr>
			<tr>
				<td>
					<div>
						<table align="center" style="width:50%;">
							<tr>
								<td>
									<div class="container">
										<div class="card">
											<div class="card-header" align="left">
												<h4 style="color:purple">
													Register
													</h4>
											</div>
											<div class="card-body">
												<div class="form-group">
													<form:form action="./registers" modelAttribute="user" method="post">
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
														<div class="form-group">
														   &nbsp;
														</div>
														<div class="form-group " align="right">
															<input type="submit" class="btn btn-primary"
																value="  Register "></input>
														</div>
													</form:form>
												</div>
											</div>

										</div>
									</div>

								</td>
							</tr>
							<tr>
				<td>&nbsp; <br>
				<td>
			</tr>
						</table>
					</div>
				<td>
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
</html>
