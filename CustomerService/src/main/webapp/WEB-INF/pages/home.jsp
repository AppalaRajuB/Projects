<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="../pages/homeheader.jsp" />

<!--  Body Start-->
		<div class="card">
			<div class="card-body" style="height: 100">
				<div class="form-group">
					<form:form action="./home" modelAttribute="users">
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
<!-- Body End -->

<jsp:include page="../pages/homefooter.jsp" />
		