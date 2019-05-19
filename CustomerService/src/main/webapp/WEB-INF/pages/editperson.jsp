<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="../pages/homeheader.jsp" />
<jsp:include page="../pages/header.jsp" />
<jsp:include page="../pages/footer.jsp" />
<head>
<link href="<%=request.getContextPath()%>/resources/css/gijgo.min.css"
	rel="stylesheet" type="text/css" />
</body>
<script src="<%=request.getContextPath()%>/resources/js/gijgo.min.js"
	type="text/javascript"></script>
<style>
	.error{color:red}
</style>
</head>

<div class="container">
	<div class="card">
		<div class="card-body">
			<div class="form-group">
				<form:form action="./details" modelAttribute="users" id="editform" enctype="multipart/form-data" method="post">
					<h5>Edit Personal Details</h5><hr>
					<div id="errors" style="color:red"></div>
					<table width="50%" align="center">
						<tr>
							<td>
							<form:hidden path="id" id="uid"/>
							<form:hidden path="persons.id" id="pid"/>
							<form:hidden path="passwd" id="password"/>
							<form:hidden path="persons.createdDate" id="creatdate"/>
							<form:hidden path="persons.filename" id="filename"/>
							
								<div class="form-group">
								<font color="red">*</font>
									<label for="email" style="color:black;font-weight:bold">Name:</label>
									<form:input type="text" class="form-control col-md-8" id="name"
										path="persons.name" placeholder="Enter name" />
									
								</div>
								<div class="form-group">
											<font color="red">*</font>
											<label style="color:black;font-weight:bold">Gender:</label>&nbsp;
											<label class="form-check-label" for="maleradio">
												<form:radiobutton id="maleradio" name="gender"
													value="male" path="persons.gender" label="Male" />&nbsp;&nbsp;
											</label> <label class="form-check-label" for="femaleradio">
												<form:radiobutton id="femaleradio" name="gender"
													value="female" path="persons.gender" label="Female" />
													
											</label>
								</div>
								<div class="form-group">
									   <font color="red">*</font>
										<label style="color:black;font-weight:bold">Date of Birth:</label>
										<form:input id="datepicker" width="200" path="persons.dateofBirth" disabled="true"/>
										
								</div> 
								<div class="form-group">
									<font color="red">*</font>
									<label for="email" style="color:black;font-weight:bold">Email address:</label>
									<form:input type="email" class="form-control col-md-8" id="email"
										path="email" placeholder="Enter email" />
										
								</div>
								
									<div class="form-group">
										    <font color="red">*</font>
											<label style="color:black;font-weight:bold">Choose Image:</label>
								    		<input type="file" class="form-control" name="file" id="fileToUpload"/>									    									    		
										</div>
									</div>
									
								<div class="form-group " align="right">
										<input type="button" class="btn btn-primary" value="  Update " onclick="enablefields();"></input>
								</div>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</div>
<script>
		$('#datepicker').datepicker({
			uiLibrary : 'bootstrap4',
			rightIcon : '<i class="material-icons">date_range</i>'
		});
		
		function enablefields()
		{
			if(document.getElementById("datepicker").value=="" || document.getElementById("name").value.trim() =="" || 
					document.getElementById("email").value.trim() =="")
			{
				document.getElementById("errors").innerHTML  = "Please enter all fields.";
				return false;
			}
			
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
			
			if(!(document.getElementById("email").value.trim()).match(mailformat))
			{
				document.getElementById("errors").innerHTML  = "Please enter valid email.";
				return false;
			}
			
			if(document.getElementById("fileToUpload").value.trim() == "")
			{
			
				document.getElementById("errors").innerHTML  = "Please upload image.";
				return false;
			}
			
			var filename = document.getElementById("fileToUpload").value.split(".");			
			if(filename[1].indexOf("jpeg") != -1 || filename[1].indexOf("pdf") != -1 || filename[1].indexOf("png") != -1 || filename[1].indexOf("jpg") != -1)
			{	
				document.getElementById("datepicker").disabled = false;
				document.getElementById("editform").submit();
				
			}else
			{
				document.getElementById("errors").innerHTML  = "Please upload image of type .pdf, .jpg or .png format";
				return false;
			}
			
						
			
		}
</script>

<jsp:include page="../pages/homefooter.jsp" />

