package result;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginValid
 */
@WebServlet("/AdminLoginValid")
public class AdminLoginValid extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
     String u=request.getParameter("name");
     String p=request.getParameter("pass");
     if(u.equals("rishav") && p.equals("rishav"))
     {
    	 request.getRequestDispatcher("AdminLogin.jsp").forward(request,response);
     }
     else
     {
    	 out.println("<h4>Invalid User Name and password</h4>");
    	 request.getRequestDispatcher("AdminLoginValid.jsp").include(request,response);
    	 
     }
     
	}

}
