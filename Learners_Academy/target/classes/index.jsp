<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Learner's
				Academy</a>
		</div>
	</nav>

	<div class="container  d-flex justify-content-center ">
		<div id="formContent" class="custom-input">
			<!-- Login Form -->
			<form action="login" method="post">
				<h5 class="text-center mt-4 mb-4 text-primary">Admin Login</h5>

				<input type="text" name="userName" placeholder="Username"
					autocomplete="off"> <br> <br> <input
					type="password" name="password" placeholder="Password"> <br>
				<br> <input type="submit" value="Log In">


			</form>
		</div>
	</div>
</body>
</html>