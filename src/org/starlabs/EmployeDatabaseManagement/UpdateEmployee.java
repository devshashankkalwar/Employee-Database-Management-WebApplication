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

@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateEmployee() {
		super();
	}

	private Connection con;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String id = "", field = "", upData = "";
		String submit = request.getParameter("submit");
		try {
			con = ConnectionFactory.getConnection("employedb");
			Statement st = con.createStatement();
			if (submit.equals("UPDATE")) {
				id = request.getParameter("Empid");
				field = request.getParameter("field");
				upData = request.getParameter("upData");
				ResultSet rs = st.executeQuery("Select * from employe where id=" + id);
				if (!rs.next()) {
					request.setAttribute("status", "Employe id not found in Database");
					request.getRequestDispatcher("/Emp_Update.jsp").forward(request, response);
				} else {
					if (!field.equals("salary")) {
						String updateQuery = "update Employe set " + field + "='" + upData + "' where ID=" + id;
						PreparedStatement ps = con.prepareStatement(updateQuery);
						ps.executeUpdate(updateQuery);
					} else {
						Double salary = Double.parseDouble(upData);
						String updateQuery = "update Employe set " + field + "=" + salary + " where ID=" + id;
						PreparedStatement ps = con.prepareStatement(updateQuery);
						ps.executeUpdate(updateQuery);
					}
					con.close();
					st.close();
					request.setAttribute("status", "Employe details has been successfully Updated.");
					request.getRequestDispatcher("/Emp_Update.jsp").forward(request, response);
				}
			}
		}catch (SQLException | NullPointerException e){
			request.setAttribute("status", "No Connection to Database");
			request.getRequestDispatcher("/Emp_Update.jsp").forward(request, response);
		}catch (NumberFormatException e) {
			request.setAttribute("status", "Please enter a valid salary");
			request.getRequestDispatcher("/Emp_Update.jsp").forward(request, response);
		}catch (Exception e) {
			System.out.println("Exception:" + e);
		}

	}

}
