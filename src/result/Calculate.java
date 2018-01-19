package result;

import java.io.IOException;
import java.sql.Connection;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dbcon;

/**
 * Servlet implementation class Calculate
 */
@WebServlet("/Calculate")
public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 HttpSession session=request.getSession(false);  
	        String n=(String)session.getAttribute("table");

		try
		{
		Connection c=new Dbcon().getCon();
		PreparedStatement p=c.prepareStatement("SELECT * FROM "+n+" ");
		
		ResultSet r=p.executeQuery();
	    int k=0;
		while(r.next()) 
		{
			String roll=r.getString(1);
			PreparedStatement ps=c.prepareStatement("UPDATE "+n+" SET GRADE=? WHERE ROLL_NO=?");	
			k=r.getInt(3)+r.getInt(4)+r.getInt(5)+r.getInt(6)+r.getInt(7)+r.getInt(8);
			
			if(k>=90)
			ps.setString(1,"O");
			else if(k>=80 && k<=89)
				ps.setString(1,"A");

			else if(k>=70 && k<=79)
				ps.setString(1,"B");

			else if(k>=60 && k<=69)
				ps.setString(1,"C");

			else if(k>=50 && k<=59)
				ps.setString(1,"D");

			else if(k>=35 && k<=49)
				ps.setString(1,"E");
			else
				ps.setString(1,"Fail");
			ps.setString(2,roll);
				ps.executeUpdate();
		}
		request.getRequestDispatcher("ShowData.jsp").forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
