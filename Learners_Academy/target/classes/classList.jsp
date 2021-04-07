<%@page import="org.simplilearn.project.model.Class"%>
<%@page import="org.simplilearn.project.service.ClassService"%>
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
	<%@ include file="classPanel.jsp"%>
	<%
	ClassService classService = new ClassService();
	List<Class> classList = classService.getAllClass();
	request.setAttribute("classList", classList);
	%>



	<div class="container w-50 ">
		<h4 class="text-center mt-4 mb-4 text-dark ">Class List</h4>
		<hr>

		<table class="table  table-bordered table-hover">
			<thead class="thead-dark ">
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th style="width: 20%">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${classList}" var="cls">

					<tr>
						<td>${cls.id}</td>
						<td>${cls.name}</td>
						<td><a class="text-primary"
							href="${pageContext.request.contextPath}/class/edit?id=<c:out value='${cls.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
							class="text-danger"
							href="${pageContext.request.contextPath}/class/delete?id=<c:out value='${cls.id}' />">
								Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
	</div>

</body>
</html>