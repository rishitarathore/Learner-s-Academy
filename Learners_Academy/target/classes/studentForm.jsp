<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.simplilearn.project.model.Class"%>
<%@page import="java.util.List"%>
<%@page import="org.simplilearn.project.service.ClassService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>

	<%@ include file="studentPanel.jsp"%>

	<%
	ClassService classService = new ClassService(); 
	List<Class> classList = classService.getAllClass();
	request.setAttribute("classList", classList);
	%>

	<div class="container w-50 ">
		<hr>
		<div class="container d-flex justify-content-center">
			<div class="formContent2">

				<!-- Form -->

				<c:if test="${student != null}">
					<form action="${pageContext.request.contextPath}/student/update"
						method="post">
				</c:if>
				<c:if test="${student == null}">
					<form action="${pageContext.request.contextPath}/student/insert"
						method="post">
				</c:if>

				<c:if test="${student != null}">
					<input type="hidden" name="id"
						value="<c:out value='${student.id}' />" />
				</c:if>


				<c:if test="${student != null}">
					<h4 class="text-center mt-1 mb-4 text-dark">Edit Student</h4>
				</c:if>
				<c:if test="${student == null}">
					<h4 class="text-center mt-1 mb-4 text-dark">Add Student</h4>
				</c:if>


				<div class=" form-row center">
					<div class="form-group col-md-6">
						<input type="text" class="form-control" placeholder="First Name"
							name="firstName" required
							value="<c:out  value='${student.first_name}' />" />
					</div>

					<div class="form-group col-md-6">
						<input type="text" class="form-control" placeholder="Last Name"
							name="lastName" required
							value="<c:out value='${student.last_name}'/>" />
					</div>

					<div class="form-group col-md-6">
						<input type="email" class="form-control" placeholder="Email-ID"
							name="email" required value="<c:out  value='${student.email}'/>" />
					</div>


					<div class="form-group col-md-6">
						<select id="classId" class="browser-default custom-select"
							name="classId" required>
							<option value="" disabled selected>Select Class</option>
							<c:forEach items="${classList}" var="item">
								<option value="${item.id}"
									${item.id == selectedOption ? 'selected' : ''}>${item.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<br> <br>
				<!-- Button -->
				<div class="col-md-12 text-center">
					<button class="btn btn-success btn-md center-block mx-2"
						type="submit">Submit</button>
				</div>
				</form>
			</div>
		</div>
</body>

</html>