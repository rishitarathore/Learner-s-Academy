<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="links.jsp" />
</head>
<body>
	<jsp:include page="classPanel.jsp" />

	<div class="container w-50 ">
		<hr>
		<div class="container d-flex justify-content-center">
			<div class="formContent2">
				<!-- Form -->
				<c:if test="${c != null}">
					<form action="${pageContext.request.contextPath}/class/update"
						method="post">
				</c:if>
				<c:if test="${c == null}">
					<form action="${pageContext.request.contextPath}/class/insert"
						method="post">
				</c:if>
				<c:if test="${c != null}">
					<input type="hidden" name="id" value="<c:out value='${c.id}' />" />
				</c:if>

				<c:if test="${c != null}">
					<h4 class="text-center mt-1 mb-4 text-dark">Edit Class</h4>
				</c:if>
				<c:if test="${c == null}">
					<h4 class="text-center mt-1 mb-4 text-dark">Add Class</h4>
				</c:if>

				<div class="form-group row center">
					<div class="col ">
						<input type="text" class="form-control" name="name"
							placeholder="Class Name" value="<c:out value='${c.name}'/>"
							required>
					</div>
				</div>
				<br>
				<!-- Button -->
				<button class="btn btn-success btn-md center-block mx-2"
					type="submit">Submit</button>
				</form>
			</div>
		</div>

	</div>
</body>
</html>