<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<br>
	<div class="container">
		<h4 class="text-center p-2 mt-4 mb-4 bg-info text-white ">Student
			Management</h4>
		<br>

	</div>
	<div class="container d-flex justify-content-center">
		<div class="row w-50" id="custom-anchor">
			<div class="col btn mx-3 btn-light">
				<a href="${pageContext.request.contextPath}/student/new">Add
					Student </a>
			</div>
			<div class="col  btn mx-3 btn-light">
				<a href="${pageContext.request.contextPath}/student/list">Student
					List</a>
			</div>
		</div>
	</div>
</body>
</html>