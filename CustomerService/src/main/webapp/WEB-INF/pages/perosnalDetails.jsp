<%@ page import="com.techm.beans.User"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page isELIgnored="false"%>
<jsp:include page="../pages/homeheader.jsp" />

<%
User user = (User)session.getAttribute("userobj");
 Long uid = user.getId();
%>

<div class="container-fluid">
<div class="card">
	<div class="card-body" >
		<div class="form-group">
			<form:form action="./home">
				<h2>Personal Details</h2>	
				<c:set var="val" value="<%= uid %>"/>			
				<table class="table table-striped" border="1">
					<thead>
						<tr>
							<th width="20%">Name</th>
							<th width="20%">Gender</th>
							<th width="20%">DOB</th>
							<th width="25%">Email</th>
							<th>FileName</th>
							<th width="20%">&nbsp;</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="reguser" items="${allRegUsers}">   
							<tr>
								
								<td>
								 <c:if test="${reguser.id == val}">
								 	<font color=red>*</font>
								 </c:if>
									${reguser.persons.name}
								 	
								</td>
								<td>${reguser.persons.gender}</td>
								<td>${reguser.persons.dob}</td>
								<td>${reguser.email}</td>
								<td>${reguser.persons.filename}</td>
								<td align="center">
								
								<c:if test="${reguser.id == val}"> 
									<a href="./editPerson?uid=${reguser.id}">
								</c:if>
								<c:if test="${reguser.id != val}"> 
									 <a href="#" data-toggle="tooltip" data-placement="top" title="You don't have permissions!">
								 </c:if>
								<img src="<%=request.getContextPath()%>/resources/images/edit.png" alt="edit" width="15%" >
								</a>
								
								</td>				
							</tr>
						</c:forEach>
				</table>
			</form:form>
		</div>
	</div>
</div>
</div>

<jsp:include page="../pages/homefooter.jsp" />