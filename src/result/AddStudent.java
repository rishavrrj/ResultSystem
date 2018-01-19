package result;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbaccess;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter out=response.getWriter(); 
		
		String n=request.getParameter("name");
		String r=request.getParameter("roll");
		String dob=request.getParameter("dob");
		Dbaccess d=new Dbaccess(n,r,dob);
		int z=d.savestudent();
		if(z>0)
		{
			out.println("<h3>Student added Succesfully</h3>");
			request.getRequestDispatcher("AddStudent.jsp").include(request,response);
			
		}
	}

}
