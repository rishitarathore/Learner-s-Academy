<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.simplilearn.project.model.Student"%>
<%@page import="java.util.List"%>
<%@page import="org.simplilearn.project.service.StudentService"%>
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
		StudentService studentService = new StudentService();   
		   List<Student> studentList = studentService.getAllStudent();
		   request.setAttribute("studentList", studentList);
		%>

	<div class="container w-75 ">
		<h4 class="text-center mt-4 mb-4 text-dark ">Student List</h4>
		<hr>
		<table class="table  table-bordered table-hover">
			<thead class="thead-dark ">
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Class</th>
					<th style="width: 14%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studentList}" var="student">

					<tr>
						<td>${student.id}</td>
						<td>${student.first_name}</td>
						<td>${student.last_name}</td>
						<td>${student.email}</td>
						<td>${student.foreignClass.name}</td>

						<td><a class="text-primary"
							href="${pageContext.request.contextPath}/student/edit?id=<c:out value='${student.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							class="text-danger"
							href="${pageContext.request.contextPath}/student/delete?id=<c:out value='${student.id}' />">
								Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>