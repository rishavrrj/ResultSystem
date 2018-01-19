package result;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dbaccess;

/**
 * Servlet implementation class TeacherLoginValid
 */
@WebServlet("/TeacherLoginValid")
public class TeacherLoginValid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String tname=request.getParameter("tname");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		Dbaccess d=new Dbaccess();
		if (!(d.teacherValid(tname,name,pass)))
		{
		out.println("Invalid Credentials");
		request.getRequestDispatcher("/TeacherLogin.jsp").include(request, response);
		}
		else
		{
		    HttpSession session=request.getSession();  
	        session.setAttribute("table",name);
			request.getRequestDispatcher("/AddMarks.jsp").forward(request, response);	
		}
		
			
	}

}
