package dao;
import java.sql.*;
public class Dbcon {
	
	public static Connection getCon()
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","resultsystem","resultsystem");
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}

}
