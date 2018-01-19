package result;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbaccess;
import dao.Dbcon;

/**
 * Servlet implementation class AddTeacher
 */
@WebServlet("/AddTeacher")
public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter(); 
		
		String n=request.getParameter("name");
		String s=request.getParameter("subject");
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		Dbaccess d=new Dbaccess(n,s,u,p);
		int z=d.saveteacher();
		if(z>0)
		{
			out.println("<h3>Teacher added Succesfully</h3>");
			request.getRequestDispatcher("AddTeacher.jsp").include(request,response);
			
		}
		else
		{

			out.println("<h3>Teacher added Succesfully</h3>");
			request.getRequestDispatcher("AddTeacher.jsp").include(request,response);
		}
		
	}

}
