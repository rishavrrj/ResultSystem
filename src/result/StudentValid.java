package result;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dbaccess;

/**
 * Servlet implementation class StudentValid
 */
@WebServlet("/StudentValid")
public class StudentValid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String r=request.getParameter("roll");
		String n=request.getParameter("name");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try
		{
			int p=0;
			ResultSet rs=new Dbaccess().getStud();
			while(rs.next())
			{
				if(n.equals(rs.getString(1)) && r.equals(rs.getString(2)) )
				{
					p=1;
					
					request.getRequestDispatcher("ViewResult.jsp").include(request, response);
				}
			}
			if(p==0) {
			out.println("Invalid Credentials");
			request.getRequestDispatcher("StudentLogin.jsp").include(request, response);
		}}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
