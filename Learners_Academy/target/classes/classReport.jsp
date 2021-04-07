<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.Set"%>
<%@page import="org.simplilearn.project.model.Class"%>
<%@page import="org.simplilearn.project.model.Subject"%>
<%@page import="org.simplilearn.project.model.Student"%>
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
	Class item = (Class) request.getAttribute("class");
	%>
	<%
	Set<Subject> subjects = item.getSubjects();
	request.setAttribute("subjects", subjects);
	%>
	<%
	Set<Student> students = item.getStudents();
	request.setAttribute("students", students);
	%>


	<div class="container w-50">



		<h3 class="text-center mt-4 mb-4 text-dark ">
			Class Report:
			<%=item.getName()%>
		</h3>
		<hr>


		<div class="container d-flex justify-content-end">
			<input class="text-center hidden-print btn btn-link" type="button"
				value="Print" onclick="window.print()" />
			<div class="text-center hidden-print btn btn-link text-danger">
				<a class="text-danger"
					href="${pageContext.request.contextPath}/classReportMenu.jsp">Back</a>
			</div>



		</div>

		<h5 class="text-center mt-4 mb-4 text-dark ">Subjects & Teachers</h5>

		<table class="table  table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Subject</th>
					<th scope="col">Teacher</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach items="${subjects}" var="subject">
					<tr>
						<th>${subject.id}</th>
						<td>${subject.name}</td>
						<td>${subject.foreignTeacher.first_name}
							${subject.foreignTeacher.last_name}</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>

		<br>
		<hr>

		<h5 class="text-center mt-4 mb-4 text-dark ">Students Enrolled</h5>

		<table class="table  table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email-ID</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<th scope="row">${student.id}</th>
						<td>${student.first_name}</td>
						<td>${student.last_name}</td>
						<td>${student.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<hr>

	</div>

</body>
</html>