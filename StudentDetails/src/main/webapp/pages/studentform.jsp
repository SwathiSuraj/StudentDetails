<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Form</title>
</head>
<body>
	<h2>Student Registration</h2>
	<form action="${submit!=null? '/update':'/save'}" method="post">
		Enter student ID:<input type="text" name="student_id" value="${student_id}"><c:if test="${submit!=null}"></c:if><br>
		Enter student Name:<input type="text" name="student_name" value="${student_name}"><br>
		Enter Course Name:<input type="text" name="course_name" value="${course_name}"><br>
		Enter Student email:<input type="email" name="student_email" value="${student_email}"><br>
		<input type="submit" value="${submit!=null? 'update' : 'save'}">
	</form>

</body>
</html>