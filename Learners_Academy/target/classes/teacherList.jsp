<%@page import="org.simplilearn.project.model.Teacher"%>
<%@page import="org.simplilearn.project.service.TeacherService"%>
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
	<%
		   TeacherService teacherService = new TeacherService();   
		   List<Teacher> teacherList = teacherService.getAllTeacher();
		   request.setAttribute("teacherList", teacherList);
		%>

	<div class="container w-75 ">
		<h4 class="text-center mt-4 mb-4 text-dark ">Teacher List</h4>
		<hr>
		<table class="table  table-bordered table-hover">
			<thead class="thead-dark ">
				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th style="width: 14%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${teacherList}" var="teacher">

					<tr>
						<td>${teacher.id}</td>
						<td>${teacher.first_name}</td>
						<td>${teacher.last_name}</td>
						<td>${teacher.email}</td>
						<td><a class="text-primary"
							href="${pageContext.request.contextPath}/teacher/edit?id=<c:out value='${teacher.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							class="text-danger"
							href="${pageContext.request.contextPath}/teacher/delete?id=<c:out value='${teacher.id}' />">
								Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>