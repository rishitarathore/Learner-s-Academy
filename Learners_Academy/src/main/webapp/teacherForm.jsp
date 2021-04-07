<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>
	<%@ include file="teacherPanel.jsp"%>

	<div class="container w-50 ">
		<hr>
		<div class="container d-flex justify-content-center">
			<div class="formContent2">


				<!-- Form -->
				<c:if test="${teacher != null}">
					<form action="${pageContext.request.contextPath}/teacher/update"
						method="post">
				</c:if>
				<c:if test="${teacher == null}">
					<form action="${pageContext.request.contextPath}/teacher/insert"
						method="post">
				</c:if>
				<c:if test="${teacher != null}">
					<input type="hidden" name="id"
						value="<c:out value='${teacher.id}' />" />
				</c:if>


				<c:if test="${teacher != null}">
					<h4 class="text-center mt-1 mb-4 text-dark">Edit Teacher</h4>
				</c:if>
				<c:if test="${teacher == null}">
					<h4 class="text-center mt-1 mb-4 text-dark">Add Teacher</h4>
				</c:if>



				<div class=" form-row center">
					<div class="form-group col-md-6">
						<input type="text" class="form-control" placeholder="First Name"
							name="firstName" required
							value="<c:out value='${teacher.first_name}' />" />
					</div>

					<div class="form-group col-md-6">
						<input type="text" class="form-control" placeholder="Last Name"
							name="lastName" required
							value="<c:out value='${teacher.last_name}'/>" />
					</div>

					<div class="form-group col-md-12 ">
						<input type="email" class="form-control" placeholder="Email-ID"
							name="email" required value="<c:out  value='${teacher.email}'/>" />
					</div>
				</div>

				<br>
				<!-- Button -->
				<button class="btn btn-success btn-md center-block mx-2"
					type="submit">Submit</button>
				</form>
			</div>
		</div>

	</div>
</body>
</html>