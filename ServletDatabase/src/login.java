import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
public class login extends HttpServlet 
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name=req.getParameter("naam");
	String password=req.getParameter("pass");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
		PreparedStatement p=cn.prepareStatement("select * from servlet where name =? and password=?");
		p.setString(1,name);
		p.setString(2,password);
		ResultSet rs=p.executeQuery();
		if(rs.next())
		{
			RequestDispatcher rd=req.getRequestDispatcher("welcome.html");
			rd.forward(req, resp);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("signup.html");
			rd.forward(req, resp);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	}
   }

