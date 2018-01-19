<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*,dao.Dbcon" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Total Marks</title>
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
<h3 align="center">Total Marks</h3>
<% ResultSet r=null;
String n=null;
try
{
	 HttpSession sess=request.getSession(false);  
      n=(String)sess.getAttribute("table");
	Connection c=new Dbcon().getCon();
	PreparedStatement p=c.prepareStatement("SELECT * FROM "+n+"");
	 r=p.executeQuery();
	 
}
catch(Exception e)
{
	e.printStackTrace();
}
%>
<h5>Course code:<%= n %></h5>
<table>
<tr style=" border:2px solid black "><th>Roll No</th><th>Name</th><th>T1</th><th>T2</th><th>End Sem</th><th>Quiz</th><th>Attendance</th><th>Assignment</th><th>Grade</th> </tr>

<% while(r.next())
{ %> 
<tr><td><%= r.getString(1) %></td><td><%=r.getString(2)%></td><td><%=r.getString(3)%></td><td><%=r.getString(4)%></td><td><%=r.getString(5)%></td><td><%=r.getString(6)%></td><td><%=r.getString(7)%></td><td><%=r.getString(8)%></td><td><%=r.getString(9)%></td></tr>
 <% } %>

</table>
</body>
</html>