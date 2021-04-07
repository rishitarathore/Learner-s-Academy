<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.simplilearn.project.model.Class"%>
<%@page import="org.simplilearn.project.service.ClassService"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="nav.jsp" />
	<%
	ClassService classService = new ClassService();
	List<Class> classList = classService.getAllClass();
	request.setAttribute("classList", classList);
	%>
	<div class="container w-50 ">
		<!-- <div class="formContent2"> -->
		<div id="formContent2">
			<form action="classreport" autocomplete="off">
				<h4 class="text-center mt-4 mb-4 text-dark ">Class Report</h4>

				<br>

				<div class="row  justify-content-md-center">
					<div class="col-4">
						<select id="classId" class="browser-default custom-select"
							name="classId" required>
							<option value="" disabled selected>Select Class</option>
							<c:forEach items="${classList}" var="item">
								<option value="${item.id}">${item.name}</option>
							</c:forEach>
						</select>
					</div>

					<!-- Button -->
					<button class="btn btn-primary btn-md center-block mx-2"
						type="submit">Search</button>
				</div>
			</form>

		</div>
	</div>
</body>
</html>