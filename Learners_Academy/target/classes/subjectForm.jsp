<%@page import="org.simplilearn.project.model.Teacher"%>
<%@page import="org.simplilearn.project.service.TeacherService"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.simplilearn.project.model.Class"%>
<%@page import="java.util.List"%>
<%@page import="org.simplilearn.project.service.ClassService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>

	<%@ include file="subjectPanel.jsp"%>

	<%
	ClassService classService = new ClassService();
	List<Class> classList = classService.getAllClass();
	request.setAttribute("classList", classList);
	%>
	<%
	TeacherService teacherService = new TeacherService();
	List<Teacher> teacherList = teacherService.getAllTeacher();
	request.setAttribute("teacherList", teacherList);
	%>


	<div class="container w-50 ">
		<hr>
		<div class="container d-flex justify-content-center">
			<div class="formContent2">



				<!-- Form -->

				<c:if test="${subject != null}">
					<form action="${pageContext.request.contextPath}/subject/update"
						method="post">
				</c:if>
				<c:if test="${subject == null}">
					<form action="${pageContext.request.contextPath}/subject/insert"
						method="post">
				</c:if>

				<c:if test="${subject != null}">
					<input type="hidden" name="id"
						value="<c:out value='${subject.id}' />" />
				</c:if>

				<c:if test="${subject != null}">
					<h4 class="text-center mt-1 mb-4 text-dark">Edit Subject</h4>
				</c:if>
				<c:if test="${subject == null}">
					<h4 class="text-center mt-1 mb-4 text-dark">Add Subject</h4>
				</c:if>

				<div class="form-group form-row ">
					<div class="col ">
						<input type="text" class="form-control" name="name"
							placeholder="Subject Name" required
							value="<c:out value='${subject.name}' />" />
					</div>

				</div>
				<div class="form-group form-row ">
					<div class="col ">
						<input type="text" class="form-control" name="code"
							placeholder="Subject Code" required
							value="<c:out value='${subject.code}'/>" />
					</div>
				</div>

				<div class="form-row  ">
					<div class="col w-75">
						<select id="classId" class="browser-default custom-select"
							name="classId" required>
							<option value="" disabled selected>Select Class</option>
							<c:forEach items="${classList}" var="item">
								<option value="${item.id}"
									${item.id == selectedOption1 ? 'selected' : ''}>${item.name}</option>
							</c:forEach>
						</select>

					</div>

					<div class="col w-75">

						<select id="teacherId" class="browser-default custom-select"
							name="teacherId" required>
							<option value="" disabled selected>Select Teacher</option>
							<c:forEach items="${teacherList}" var="teacher">
								<option value="${teacher.id}"
									${teacher.id == selectedOption2 ? 'selected' : ''}>${teacher.first_name}
									${teacher.last_name}</option>
							</c:forEach>
						</select>

					</div>
				</div>

				<br>
				<br>
				<!-- Button -->
				<div class="col-md-12 text-center">
					<button class="btn btn-success btn-md center-block mx-2"
						type="submit">Submit</button>
				</div>
				</form>

			</div>
		</div>
</body>

</html>