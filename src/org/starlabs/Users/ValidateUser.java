package org.starlabs.Users;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.starlabs.connectionManager.ConnectionFactory;

public class ValidateUser {
	
	private Connection con;
	private Statement stmt;
	User user=null;
	
	public User validateUser(String email, String password,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		 	
		try{
			con = ConnectionFactory.getConnection("userdb");
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from user where email = '"+email+"' and Password = '"+password+"'");
			if(rs.next()){
				user=new User();
				user.email=rs.getString(3);
				user.name=rs.getString(1)+" "+rs.getString(2);
				user.password=rs.getString(4);
				return user;
			}
				else
			return user;
		}catch (SQLException | NullPointerException e){
			request.setAttribute("status", "Connection Cannot be Established");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
			return user;
		}catch(Exception e){
			return user;
		}finally{
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}
}
