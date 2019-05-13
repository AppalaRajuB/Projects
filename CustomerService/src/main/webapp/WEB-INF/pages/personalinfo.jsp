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
</style>
<link href="<%=request.getContextPath()%>/resources/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
</body>
<script src="<%=request.getContextPath()%>/resources/js/gijgo.min.js"
	type="text/javascript"></script>
</head>

<body>
	<div class="container">
		<table style="width:100%;"class="borders">
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
		<table style="width:100%;"
			background="<%=request.getContextPath()%>/resources/images/bgimage.jpg"
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
												<h4 style="color: purple">Personal Details</h4>
											</div>
											<div class="card-body">
											<form:form action="./persons" modelAttribute="users" method="post">
												<div class="form-group">													
														<div class="form-group">
															<h6><label for="email">Name:</label></h6>
															<form:input type="text" class="form-control" id="name"
																path="persons.name" placeholder="Enter name" />
														</div>
														<div class="form-group">
															<div class="row">
																<div class="col-md-12">
																	<h6><label>Gender:</label></h6> <label
																		class="form-check-label" for="maleradio"> <form:radiobutton
																			id="maleradio" name="gender" value="male"
																			path="persons.gender" label="Male" />
																	</label> <label class="form-check-label" for="femaleradio">
																		<form:radiobutton id="femaleradio" name="gender"
																			value="female" path="persons.gender" label="Female" />
																	</label> <label class="form-check-label" for="femaleradio">
																		<form:radiobutton id="transgendereradio" name="gender"
																			value="transgender" path="persons.gender" label="Transgender" />

																	</label>
																</div>
															</div>
														</div>
														<div class="form-group">
														    <h6><label>Date of Birth:</label></h6>
															<form:input id="datepicker" width="200" path="persons.dob" />															
														</div>
												</div>												
												<div class="form-group " align="right">
													<input type="submit" class="btn btn-primary"
															value="  Save "></input>
												</div>
												</form:form>
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
	</script>
   
 

</html>
