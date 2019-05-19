<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Personal Details</title>
<jsp:include page="../pages/header.jsp" />
<jsp:include page="../pages/footer.jsp" />
<style>
.borders {
	border: 1px solid black;
}
.error{color:red}
</style>
<link href="<%=request.getContextPath()%>/resources/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
</body>
<script src="<%=request.getContextPath()%>/resources/js/gijgo.min.js"
	type="text/javascript"></script>
</head>

<body>
	<div class="container">
		<table style="width: 100%;" class="borders">
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
		<table style="width: 100%;"
			background="<%=request.getContextPath()%>/resources/images/bgimage.jpg"
			class="borders">
			<tr>
				<td>&nbsp; <br>
				<td>
			</tr>
			<tr>
				<td>
					<div>
						<table align="center" style="width: 50%;">
							<tr>
								<td>
									<div class="container">
										<div class="card">
											<div class="card-header" align="left">
												<h4 style="color: purple">Personal Details</h4>
											</div>
											<div class="card-body">
												<div class="form-group">
													<form:form action="./personal" modelAttribute="persons">
														<div class="form-group">
															<font color="red">*</font>
															<label for="email" style="font-weight: bold">Name:</label>
															<form:input type="text" class="form-control" id="name"
																path="name" placeholder="Enter name"  maxlength="50"/>
																<form:errors path="name" class="form-control text-danger" cssClass="error"/>
														</div>
													 	<div class="form-group">
															<div class="row">
																<div class="col-md-12">
																	<font color="red">*</font>
																	<label  style="font-weight: bold">Gender:</label>
																	<label class="form-check-label" for="maleradio">
																		<form:radiobutton id="maleradio" name="gender"
																			value="male" path="gender" label="Male" />
																	</label>
																	 <label class="form-check-label" for="femaleradio">
																		<form:radiobutton id="femaleradio" name="gender"
																			value="female" path="gender" label="Female" />
																	</label>
																	<form:errors path="gender" class="form-control text-danger" cssClass="error"/>
																</div>
															</div>
														</div>
													  <div class="form-group">
															<font color="red">*</font>
															<label  style="font-weight: bold">Date of Birth:</label>
															<form:input id="datepicker" width="200" path="dateofBirth" disabled="true"/>
															<form:errors path="dateofBirth" class="form-control text-danger" cssClass="error"/>
														</div> 

														<div class="form-group " align="right">
															<input type="submit" class="btn btn-primary"
																value="  Save " onclick="enablefields();"></input>
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
		<BR> <br>
		<div align="center">
			<span class="copyright" style="color: gray"> &copy; 2019 Tech
				Mahindra Ltd. All rights reserved.</span>
		</div>
	</div>
	<script>
		$('#datepicker').datepicker({
			uiLibrary : 'bootstrap4',
			rightIcon : '<i class="material-icons">date_range</i>'
		});
		
		function enablefields()
		{
			document.getElementById("datepicker").disabled = false;
			return true;
		}
	</script>
</html>
