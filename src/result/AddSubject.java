package result;

import java.io.*;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbaccess;

/**
 * Servlet implementation class AddSubject
 */
@WebServlet("/AddSubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String c=request.getParameter("code");
		String n=request.getParameter("name");
		String cr=request.getParameter("credits");
		int p=Integer.parseInt(cr);
		Dbaccess d=new Dbaccess(c,n,p);
		int z=d.savesub();
		if(z>0)
		{
			out.println("<h3>Subject added Succesfully</h3>");
			request.getRequestDispatcher("AddSubject.jsp").include(request,response);
			
		}
		
		
	}

}
