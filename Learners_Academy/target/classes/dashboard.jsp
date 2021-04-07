<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark " id="mainNav">
		<div class="container">


			<a class="navbar-brand" href="#">Learner's Academy</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link "
						href="${pageContext.request.contextPath}/">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<br>
	<h4 class="text-center mt-4 mb-4 text-danger">Admin Dashboard</h4>
	<br>

	<div class="container d-flex justify-content-center">

		<div class="row-12 w-25 " id="custom-anchor">
			<div class="col btn my-3 btn-light">
				<a href="${pageContext.request.contextPath}/class">Manage Class
				</a>
			</div>
			<div class="col  btn my-3 btn-light">
				<a href="${pageContext.request.contextPath}/teacher">Manage
					Teacher</a>
			</div>
			<div class="col btn my-3 btn-light">
				<a href="${pageContext.request.contextPath}/subject">Manage
					Subject</a>
			</div>
			<div class="col btn my-3 btn-light">
				<a href="${pageContext.request.contextPath}/student">Manage
					Student</a>
			</div>
			<div class="col btn my-3 btn-light">
				<a href="${pageContext.request.contextPath}/classReportMenu.jsp">View
					Class Report</a>
			</div>
		</div>

	</div>
</body>
</html>