<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.Dbaccess,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Login to View the Result</h2>
<form method="post" action="StudentValid">
<table> 
<tr><td>Roll no</td><td><input type="text" name="roll"></td></tr>
<tr><td>Name</td><td><input type="text" name="name"></td></tr>
<tr><td></td><td><input type="submit" value="Login"></td></tr>
</table>
</form>
</body>
</html>