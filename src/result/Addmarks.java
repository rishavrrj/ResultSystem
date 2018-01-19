package result;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dbcon;

/**
 * Servlet implementation class Addmarks
 */
@WebServlet("/Addmarks")
public class Addmarks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s,r,t;
		 s=request.getParameter("input");
		 r=request.getParameter("input1");
		 t=request.getParameter("input2");
		 int z=Integer.parseInt(s);
		 response.setContentType("text/html");
		 Connection c=Dbcon.getCon();
		 HttpSession session=request.getSession(false);  
	        String n=(String)session.getAttribute("table"); 
		 try
		 {
			 String string = "UPDATE " + n + " SET " + t + "=? WHERE ROLL_NO=?";
			
			 PreparedStatement p=c.prepareStatement(string);
			 p.setInt(1, z);
			 p.setString(2, r);
		     p.executeUpdate();
				c.close();
		 }		 
        catch(Exception e)
		 {}
	}

}
