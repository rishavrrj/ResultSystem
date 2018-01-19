<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.Dbaccess,java.sql.* " %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add T1 Marks</title>
<style>
table {
border-collapse:collapse;

}
table,th,td
{
border:1px solid black;
}
input{
border:none;
}
</style>
</head>
<body>
<h2 align="center">Add Marks</h2>
<form >
<table>

<tr style=" border:2px solid black " ><th>Roll No:</th><th>Name</th><th>Marks</th></tr>
<% 
try{
	String s=request.getParameter("col");
	ResultSet r=new Dbaccess().addMarks();
	int i=0;
	while(r.next())
	{%>
<tr><td><%= r.getString(2)%></td><td><%= r.getString(1) %></td><td><input id="exam" type="text" name="<%= r.getString(2) %>"></td><td><input type="hidden" id="col" value="<%= s %>"></tr>

<% } }
catch(Exception e)
{
	System.out.println(e);
}
%>

</table>
</form>
<button id="go">Submit</button>
</body>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="script.js"></script>
</html>