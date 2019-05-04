import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signup extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     String name=req.getParameter("naam");
     String password=req.getParameter("pass");
     String course=req.getParameter("course");
     String email=req.getParameter("email");
     String address=req.getParameter("address");
     
     try
     {
    Class.forName("com.mysql.jdbc.Driver");
 	Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
     String s="insert into servlet values(?,?,?,?,?)";
     PreparedStatement p=cn.prepareStatement(s);
     p.setString(1, name);
     p.setString(2, password);
     p.setString(3, course);
     p.setString(4, email);
     p.setString(5, address);
     
     int i=p.executeUpdate();
     if(i>0)
     {
    	 RequestDispatcher rd=req.getRequestDispatcher("login.html");
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
