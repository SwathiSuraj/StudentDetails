<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1px">
<tr>
	<th>ID</th>
	<th>Name></th>
	<th>Course Name</th>
	<th>Email</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>

<c:forEach var="student" items="${submit}">
	<tr>
	<td>${student.student_id}</td>
	<td>${student.student_name}</td>
	<td>${student.course_name}</td>
	<td>${student.student_email}</td>
	<td>
	<a href="/edit/${student.student_id}"><button>Edit</button></a></td>
	<td>
	<a href="/delete/${student.student_id}"><button>Delete</button></a></td>
</tr>

</c:forEach>

</table>
	<h3>Student saved successfully</h3>
	<a href="/studentform">Create new student</a>
 
</body>

</html>