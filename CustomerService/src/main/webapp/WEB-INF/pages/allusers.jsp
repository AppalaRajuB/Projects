<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="../pages/homeheader.jsp" />

<div class="container-fluid">
<div class="card">
	<div class="card-body" >
		<div class="form-group">
			<form:form action="./home" modelAttribute="users">
				<h2>All Users</h2>				
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Gender</th>
							<th>DOB</th>
							<th>Created Date</th>
							<th>Updated Date</th>	
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>John</td>
							<td>Doe</td>
							<td>john@example.com</td>
							<td>john@example.com</td>
							<td>john@example.com</td>
							
						</tr>
						<tr>
							<td>John</td>
							<td>Doe</td>
							<td>john@example.com</td>
							<td>john@example.com</td>
							<td>john@example.com</td>							
						</tr>
				</table>
			</form:form>
		</div>
	</div>
</div>
</div>

<jsp:include page="../pages/homefooter.jsp" />