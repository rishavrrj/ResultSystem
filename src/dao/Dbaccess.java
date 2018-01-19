package dao;

import java.sql.*;

public class Dbaccess {
	String name,stname,roll,dob,sub,uname,pass;
	String code,sname;
	int credits;
	public	Dbaccess() 
	{}
	public	Dbaccess(String code,String sname,int credits)
		{
			this.code=code;
			this.sname=sname;
			this.credits=credits;
		}
	public	Dbaccess(String name,String sub,String uname,String pass)
	{
		this.name=name;
		this.sub=sub;
		this.uname=uname;
		this.pass=pass;
	}
	public	Dbaccess(String stname,String roll,String dob)
	{
		this.stname=stname;
		this.roll=roll;
		this.dob=dob;
	}
	public ResultSet getTeacher()
	{
		ResultSet r=null;
	try {
		Connection c=Dbcon.getCon();
		PreparedStatement p=c.prepareStatement("select * from AddTeacher");
		r=p.executeQuery();
		 
	}
	catch(Exception e)
	{}
		return r;
		
	}
	public int saveteacher()
	{
		Connection c=Dbcon.getCon();
	int p=0;
		try
		{
		PreparedStatement ps=c.prepareStatement("insert into AddTeacher values(?,?,?,?)");
		ps.setString(1,name);
		ps.setString(2,sub);
		ps.setString(3,uname);
		ps.setString(4,pass);
		p=ps.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
	}
	public int savesub()
	{
		Connection c=Dbcon.getCon();
	int p=0;
		try
		{
		PreparedStatement ps=c.prepareStatement("insert into AddSubject values(?,?,?)");
		ps.setString(1,code);
		ps.setString(2,sname);
		ps.setInt(3,credits);
		p=ps.executeUpdate();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
	}

	public int savestudent()
	{
		Connection c=Dbcon.getCon();
	int p=0;
		try
		{
		PreparedStatement ps=c.prepareStatement("insert into AddStudent values(?,?,?)");
		PreparedStatement p1=c.prepareStatement("insert into ec501(roll_no,name) values(?,?)");
		PreparedStatement p2=c.prepareStatement("insert into ec502(roll_no,name) values(?,?)");
		PreparedStatement p3=c.prepareStatement("insert into ec503(roll_no,name) values(?,?)");
		PreparedStatement p4=c.prepareStatement("insert into ec504(roll_no,name) values(?,?)");
		PreparedStatement p5=c.prepareStatement("insert into ec505(roll_no,name) values(?,?)");
		ps.setString(1,stname);
		ps.setString(2,roll);
		ps.setString(3,dob);
		
		p1.setString(2,stname);
		p1.setString(1,roll);
		
		p2.setString(2,stname);
		p2.setString(1,roll);
		
		p3.setString(2,stname);
		p3.setString(1,roll);
		
		p4.setString(2,stname);
		p4.setString(1,roll);
		
		p5.setString(2,stname);
		p5.setString(1,roll);
		p=ps.executeUpdate();
		p1.executeUpdate();
		p2.executeUpdate();
		p3.executeUpdate();
		p4.executeUpdate();
		p5.executeUpdate();
		c.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return p;
	}
	public boolean teacherValid(String t,String n,String p)
	{
		Connection c=Dbcon.getCon();
		int f=0;
		ResultSet r=null;
	try {
		PreparedStatement ps=c.prepareStatement("select * from AddTeacher");
		r=ps.executeQuery();
		while(r.next())
		{
			if(r.getString(1).equals(t) && r.getString(3).equals(n) &&  r.getString(4).equals(p))
			{
				f=1;
				break;
			}
		}
	}
	catch(Exception e)
	{}
	if(f==1)
		return true;
	else
		return false;
	}
	public ResultSet addMarks()
	{
		ResultSet r = null;
		Connection c=Dbcon.getCon();
		try {
			PreparedStatement ps=c.prepareStatement("select * from AddStudent");
			r=ps.executeQuery();
	  }
		catch(Exception e)
		{
			System.out.println(e);
		}
		 
		return r;
	}
	public ResultSet getStud()
	{
		ResultSet r=null;
		Connection c=null;
	try {
		 c=Dbcon.getCon();
		PreparedStatement p=c.prepareStatement("select NAME,ROLL_NO from ADDSTUDENT");
		r=p.executeQuery();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

		return r;
		
	}
}
