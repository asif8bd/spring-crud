<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Spring CRUD Example || ASIF</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>
	<h2 class="container">Spring CRUD Example || Edit Student Info</h2>
	<br />

	<%
		String id = request.getParameter("studentId");
		String name = request.getParameter("studentName");
		String email = request.getParameter("studentEmail");
	%>




	<div class="container">
		<form class="form-inline" method="post" action="edit.html">
			<div class="form-group">
				<label for="studentId"> Student ID</label> <input type="text"
					name="studentId" class="form-control" id="studentId"
					value="<%=id%>">
			</div>
			<div class="form-group">
				<label for="name"> Student Name</label> <input type="text"
					name="studentName" class="form-control" id="name" value="<%=name%>">
			</div>
			<div class="form-group">
				<label for="email">Student Email</label> <input type="email"
					class="form-control" id="email" name="studentEmail"
					value="<%=email%>">
			</div>
			<button type="submit" class="btn btn-success">Update</button>

		</form>
	</div>
</body>
</html>
