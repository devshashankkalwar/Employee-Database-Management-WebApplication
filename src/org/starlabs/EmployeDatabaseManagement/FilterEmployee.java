package org.starlabs.EmployeDatabaseManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.starlabs.connectionManager.ConnectionFactory;

@WebServlet("/FilterEmployee")
public class FilterEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FilterEmployee() {
		super();

	}

	private Connection con;
	private Statement stmt;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id="";
	String btnresponse = request.getParameter("submit");
	if(btnresponse.equals("SUBMIT")){
		try{
		con = ConnectionFactory.getConnection("employedb");
		stmt= con.createStatement();
		id=request.getParameter("Empid");
		ResultSet rs = stmt.executeQuery("select * from employe where id="+id);
		if(!rs.next()){
			request.setAttribute("status", "Employe not found in Database");
			request.getRequestDispatcher("/Emp_Filter.jsp").forward(request, response);
		}
		else{
			StringBuffer bufferreader = new StringBuffer();
			bufferreader.append("<table border=1,cellpading = 5><tr>"
							+ "<td>ID</td><td>Name</td><td>Email</td><td>Salary</td><td>Department</td></tr>");
			bufferreader.append("<tr><td>" + rs.getInt(1) + "</td>");
			bufferreader.append("<td>" + rs.getString(2) + "</td>");
			bufferreader.append("<td>" + rs.getString(3) + "</td>");
			bufferreader.append("<td>" + rs.getString(4) + "</td>");
			bufferreader.append("<td>" + rs.getString(5) + "</td></tr>");
			bufferreader.append("</table>");
			request.setAttribute("status",bufferreader);
			request.getRequestDispatcher("/Emp_Filter.jsp").forward(request, response);
		}
	}catch (SQLException | NullPointerException e){
		request.setAttribute("status", "No Connection to Database");
		request.getRequestDispatcher("/Emp_Filter.jsp").forward(request, response);
	}catch(Exception e){
		System.out.println(""+e);
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
}
