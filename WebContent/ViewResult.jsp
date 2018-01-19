<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="dao.Dbcon,java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
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
<%
String r=request.getParameter("roll");
   String n=request.getParameter("name");
   ResultSet[] rs;
   rs=new ResultSet[5];
   ResultSet z=null;
   PreparedStatement[] p;
   p=new PreparedStatement[5];
   PreparedStatement ps=null;
   int i;
   Connection c=null;
   int credits=0,m,fail=0;
   float cg,k=0;
   try
   {
	  c=new Dbcon().getCon();
	   p[0]=c.prepareStatement("select * from EC501 where roll_no=?");
	 p[1]=c.prepareStatement("select * from EC502 where roll_no=?");
	  p[2]=c.prepareStatement("select * from EC503 where roll_no=?");
	    p[3]=c.prepareStatement("select * from EC504 where roll_no=?");
	   p[4]=c.prepareStatement("select * from EC505 where roll_no=?");
	    i=0;
	    ps=c.prepareStatement("select * from addsubject");
	    z=ps.executeQuery();
	    while(i<5)
	    {
	    	p[i].setString(1,r);
	    	rs[i]=p[i].executeQuery();
	    	i++;
	    	
	    }
   }
   catch(Exception e)
   {
	   e.printStackTrace();
   }
   %>
   <h4>Name:<%= n %></h4>
   <h4>Roll No:<%= r %></h4>
<table>
<tr style=" border:2px solid black ">
<th>Course Code</th>
<th>Subject</th>
<th>Credits</th>
<th>T1</th><th>T2</th><th>End Sem</th>
<th>Quiz</th><th>Attendance</th><th>Assignment</th><th>Grade</th></tr>
<%
i=0;
while(i<5 && rs[i].next() && z.next()) {
%>
<tr>
<td><%= z.getString(1) %></td>
<td><%= z.getString(2) %></td>
<td><%= z.getInt(3) %></td>
<td><%= rs[i].getInt(3) %></td>
<td><%= rs[i].getInt(4) %></td>
<td><%= rs[i].getInt(5) %></td>
<td><%= rs[i].getInt(6) %></td>
<td><%= rs[i].getInt(7) %></td>
<td><%= rs[i].getInt(8) %></td>
<td><%= rs[i].getString(9) %></td>
</tr>
<% 
m=z.getInt(3);
credits+=m;
if(rs[i].getString(9).equals("O"))
k+=10*m;
else if(rs[i].getString(9).equals("A"))
k+=9*m;
else if(rs[i].getString(9).equals("B"))
k+=8*m;
else if(rs[i].getString(9).equals("C"))
k+=7*m;
else if(rs[i].getString(9).equals("D"))
k+=6*m;
else if(rs[i].getString(9).equals("E"))
k+=5*m;
else if(rs[i].getString(9).equals("Fail"))
{
	fail=1;
	k=0;
}

i++;
} 
cg=(k/credits); %>
</table>
<h4 align="center">CGPA:<%= cg %></h4>
</body>
</html>