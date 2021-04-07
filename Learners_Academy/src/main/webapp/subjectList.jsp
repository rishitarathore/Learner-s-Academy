<%@page import="org.simplilearn.project.model.Subject"%>
<%@page import="org.simplilearn.project.service.SubjectService"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>
	<%@ include file="subjectPanel.jsp"%>
	<%
		SubjectService subjectService = new SubjectService();   
		   List<Subject> subjectList = subjectService.getAllSubject();
		   request.setAttribute("subjectList", subjectList);
		%>



	<div class="container w-75 ">
		<h4 class="text-center mt-4 mb-4 text-dark ">Teacher List</h4>
		<hr>
		<table class="table  table-bordered table-hover">
			<thead class="thead-dark ">
				<tr>
					<th>Id</th>
					<th>Subject Name</th>
					<th>Subject Code</th>
					<th>Teacher</th>
					<th>Class</th>
					<th style="width: 14%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${subjectList}" var="subject">

					<tr>
						<td>${subject.id}</td>
						<td>${subject.name}</td>
						<td>${subject.code}</td>
						<td>${subject.foreignTeacher.first_name}
							${subject.foreignTeacher.last_name}</td>
						<td>${subject.foreignClass.name}</td>

						<td><a class="text-primary"
							href="${pageContext.request.contextPath}/subject/edit?id=<c:out value='${subject.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							class="text-danger"
							href="${pageContext.request.contextPath}/subject/delete?id=<c:out value='${subject.id}' />">
								Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>