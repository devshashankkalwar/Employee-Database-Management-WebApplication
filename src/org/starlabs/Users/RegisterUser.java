package org.starlabs.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.starlabs.connectionManager.ConnectionFactory;

public class RegisterUser {
	private Connection con;
	private PreparedStatement stmt;
	
	public boolean registerUser(String fName,String lName, String email, String password,
			String contact, String dob, String gender )throws SQLIntegrityConstraintViolationException, SQLException, 
														NullPointerException, Exception
	{
		try{
		con = ConnectionFactory.getConnection("userdb");
		String insertQuery = "insert into user values(?,?,?,?,?,?,?)";
		stmt = con.prepareStatement(insertQuery);
		stmt.setString(1, fName);
		stmt.setString(2, lName);
		stmt.setString(3, email);
		stmt.setString(4, password);
		stmt.setString(5, contact);
		stmt.setString(6, dob);
		stmt.setString(7, gender);
		
		stmt.executeUpdate();
		
		return true;
		}finally {
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
