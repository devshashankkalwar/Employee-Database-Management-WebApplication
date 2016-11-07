package org.starlabs.EmployeDatabaseManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.starlabs.connectionManager.ConnectionFactory;

@WebServlet("/DeleteEmployee")
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Connection con;
    private String id="",submit="";
    private Statement st;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		submit=request.getParameter("submit");
	try{
		con = ConnectionFactory.getConnection("employedb");
		st=con.createStatement();
		if(submit.equals("DELETE")){
			id = request.getParameter("Empid");
			ResultSet rs = st.executeQuery("Select * from employe where id=" + id);
			if (!rs.next()) {
				request.setAttribute("status", "Employe id not found in Database");
				request.getRequestDispatcher("/Emp_Delete.jsp").forward(request, response);
			} else {
				PreparedStatement ps = con.prepareStatement("delete from employe where id="+id);
				ps.executeUpdate("delete from employe where id="+id);
				request.setAttribute("status", "Employe has been Deleted from database");
				request.getRequestDispatcher("/Emp_Delete.jsp").forward(request, response);
				}
		}
	}catch(SQLException | NullPointerException e){
		request.setAttribute("status", "Cannot Connect to the Databse");
		request.getRequestDispatcher("/Emp_Delete.jsp").forward(request, response);
	}finally{
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
	}
	
}
}
