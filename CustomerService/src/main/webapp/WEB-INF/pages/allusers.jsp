<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored="false"%>
<jsp:include page="../pages/homeheader.jsp" />

<div class="container-fluid">
<div class="card">
	<div class="card-body" >
		<div class="form-group">
			<form:form action="./home">
				<h2>All Users</h2><hr>			
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Gender</th>
							<th>DOB</th>
							<th>Email</th>
							<th>Created Date</th>
							<th>Updated Date</th>								
						</tr>
					</thead>
					<tbody>
						<c:forEach var="reguser" items="${allRegUsers}">   
							<tr>
								<td>${reguser.persons.name}</td>
								<td>${reguser.persons.gender}</td>
								<td>${reguser.persons.dob}</td>
								<td>${reguser.email}</td>
								<td>${reguser.persons.createdDate}</td>	
								<td>${reguser.persons.updateDate}</td>					
							</tr>
						</c:forEach>
				</table>
			</form:form>
		</div>
	</div>
</div>
</div>

<jsp:include page="../pages/homefooter.jsp" />