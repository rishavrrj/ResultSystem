<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Subject</title>
</head>
<body>
<h1 align="center">Add Subject</h1>
<a href="AdminLogin.jsp">Home</a>
<form method="post" action="AddSubject">
<table>
<tr><td>Course Code:</td><td><input type="text" name="code" required></td></tr>
<tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
<tr><td>Credits:</td><td><input type="text" name="credits" required></td></tr>
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
</body>
</html>