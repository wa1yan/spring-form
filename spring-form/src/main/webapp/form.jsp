<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring form page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container pt-4">
		<h3><sp:message code="app.title"></sp:message></h3>
		
		<c:if test="${not empty allError}">
			<div class="alert alert-warning">
				<c:forEach items="${allError}" var="e">
					<p>${e}</p>
				</c:forEach>
			</div>	
		</c:if>
		<sf:form modelAttribute="userInput">
			<div class="row">
				<div class="col">
					<sf:label path="name">Student Name</sf:label>
					<sf:input path="name" cssClass="form-control" placeholder="Enter student name"/>
					<sf:errors path="name" cssClass="text-danger"></sf:errors>
				</div>
				
				<div class="col">
					<sf:label path="phone">Phone</sf:label>
					<sf:input path="phone" type="tel" cssClass="form-control" placeholder="Enter phone number"/>
				<sf:errors path="phone" cssClass="text-danger"></sf:errors>
				</div>
				
				<div class="col">
					<sf:label path="email">Email Address</sf:label>
					<sf:input path="email" type="email" cssClass="form-control" placeholder="Enter email address"/>
					<sf:errors path="email" cssClass="text-danger"></sf:errors>
				</div>	
			</div>
			<div class="row mt-4">
				<div class="col">
					<sf:label path="password">Password</sf:label>
					<sf:password path="password" cssClass="form-control" placeholder="Enter student name"/>
					<sf:errors path="password" cssClass="text-danger"></sf:errors>
				
				</div>
				
				<div class="col">
					<sf:label path="course">Select Course</sf:label>
					<sf:select path="course" cssClass="form-select">
						<sf:option value="">Select Course</sf:option>
						<sf:options items="${ courses }" itemValue="id" itemLabel="name"/>
					</sf:select>
					<sf:errors path="course" cssClass="text-danger"></sf:errors>
					
				</div>
				
				<div class="col">
					<sf:label path="registration">Registration Date</sf:label>
					<sf:input path="registration" cssClass="form-control" type="date"></sf:input>
				</div>	
			</div>
			
			<div class="row mt-4">
				<div class="col">
					<sf:label path="gender">Gender</sf:label>
					<div class="radio-box">
						<sf:radiobuttons path="gender" items="${ genders }"  cssClass="me-2"/>
					</div>
					<sf:errors path="gender" cssClass="text-danger"></sf:errors>
				</div>
				<div class="col">
					<sf:label path="foundations">Knowledge</sf:label>
					<div class="radio-box">
						<sf:checkboxes items="${ foundations }" path="foundations" cssClass="me-2"/>
					</div>
					<sf:errors path="foundations" cssClass="text-danger"></sf:errors>
				</div>
				<div class="col">
					<sf:label path="agree">Agree Condition</sf:label>
					<div class="radio-box">
						<sf:checkbox path="agree" label="Yes, I agree" cssClass="me-2"/>
					
					</div>
					<sf:errors path="agree" cssClass="text-danger"></sf:errors>
				</div>
			</div>
			<div class="row mt-4">
				<div class="col">
					<sf:label path="remark">Remark</sf:label>
					<sf:textarea path="remark" cssClass="form-control"/>
				</div>
			</div>
			<div class="mt-4">
				<button type="submit" class="btn btn-primary">Send</button>
			</div>		
		</sf:form>		
	</div>
	<div class="container mt-4">
		<div class="row">
			<div class="col">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Name</th>
							<th>Phone</th>
							<th>Email</th>
							<th>Course</th>
							<th>Registration</th>
							<th>Gender</th>
							<th>Foundations</th>
							<th>Agree</th>
							<th>Remark</th>
					</thead>
					<tbody>
						<c:forEach var="data" items="${ list }">
							<tr>
								<td>${ data.name }</td>
								<td>${ data.phone }</td>
								<td>${ data.email }</td>
								<td>${ data.course.name }</td>
								<td>${ data.registration }</td>
								<td>${ data.gender }</td>
								<td>
									<c:forEach items="${ data.foundations }" var="foundation">
										<p>${ foundation }</p>
									</c:forEach>
								</td>
								<td>${ data.agree }</td>
								<td>${ data.remark }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
<style>
	.radio-box > span {
		margin-right: 10px;
	}
</style>
</html>