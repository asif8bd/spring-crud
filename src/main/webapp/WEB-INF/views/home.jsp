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
	<h2 class="container">Spring CRUD Example</h2>
	<br />

	<div class="container">
		<form class="form-inline" method="post" action="insertStudent.html">
			<div class="form-group">
				<label for="name"> Student Name</label> <input type="text"
					name="studentName" class="form-control" id="name"
					placeholder="Jane Doe">
			</div>
			<div class="form-group">
				<label for="email">Student Email</label> <input type="email"
					class="form-control" id="email" name="studentEmail"
					placeholder="jane.doe@example.com">
			</div>
			<button type="submit" class="btn btn-success">Save</button>
			<span style="color: green;">${message}</span>
		</form>
		<form action="searchAll.html">
			<input type="submit" value="Display Table" class="btn btn-primary" />
		</form>
	</div>
	<div class="container">
		<c:if test="${!empty alldata}">

			<table class="table table-striped">
				<tr>
					<th>#</th>
					<th>Student Name</th>
					<th>Student Email</th>
					<th>Update Info</th>
				</tr>

				<c:forEach var="row" items="${alldata}">
					<tr>
						<td><c:out value="${row.studentId}" /></td>
						<td><c:out value="${row.studentName}" /></td>
						<td><c:out value="${row.studentEmail}" /></td>
						<td>
							<a href="edit.html?studentId=${row.studentId}&studentName=${row.studentName}&studentEmail=${row.studentEmail}">Edit</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>		
	</div>
	<div class="container">
	<a href="${pageContext.request.contextPath}"  class="btn btn-primary" >Home Page</a>
	</div>
</body>
</html>
