package org.starlabs.EmployeDatabaseManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.starlabs.connectionManager.ConnectionFactory;

import com.mysql.jdbc.exceptions.*;

@WebServlet("/InsertEmployee")
public class InsertEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter out;
	private Connection con;
	private PreparedStatement ps;

	public InsertEmployee() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String req = request.getParameter("submit");
		String id = "", name = "", email = "", department = "", salary = "";
		try {
			out = response.getWriter();
			con = ConnectionFactory.getConnection("employedb");
			if (req.equals("INSERT")) {
				id = request.getParameter("Empid");
				name = request.getParameter("Empname");
				email = request.getParameter("Empemail");
				department = request.getParameter("Empdepartment");
				salary = request.getParameter("Empsalary");
				if (id.equals("") || name.equals("") || email.equals("") || salary.equals("")
						|| department.equals("")) {
					request.setAttribute("Message", "*All Fields are Mandatory");
					request.getRequestDispatcher("/Emp_Insert.jsp").forward(request, response);
				} else {
					out = response.getWriter();
					String insertQuery = "insert into Employe values(?,?,?,?,?)";
					ps = con.prepareStatement(insertQuery);
					ps.setInt(1, Integer.parseInt(id));
					ps.setString(2, name);
					ps.setString(3, email);
					ps.setDouble(4, Double.parseDouble(salary));
					ps.setString(5, department);

					ps.executeUpdate();
					request.setAttribute("Message", "Employe details has been successfully added.");
					request.getRequestDispatcher("/Emp_Insert.jsp").forward(request, response);
				}
			}
		} catch (SQLIntegrityConstraintViolationException e) {
			request.setAttribute("Message", "Employee with same ID or Email is already present in the Database.");
			request.getRequestDispatcher("/Emp_Insert.jsp").forward(request, response);
		} catch (SQLException | NullPointerException e){
			request.setAttribute("Message", "No Connection to Database");
			request.getRequestDispatcher("/Emp_Insert.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
