<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teacher Form</title>
</head>
<body>
<h1 align="center">Add Teacher Credentials</h1>
<a href="AdminLogin.jsp">Home</a>
<form method="post" action="AddTeacher">
<table>
<tr><td>Name:</td><td><input type="text" name="name" required></td></tr>
<tr><td>Subject Assigned:</td><td><input type="text" name="subject" required></td></tr>
<tr><td>Username:</td><td><input type="text" name="username" required></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" required></td></tr>
<tr><td></td><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
</body>
</html>