package org.starlabs.EmployeDatabaseManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mysql.jdbc.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.starlabs.connectionManager.ConnectionFactory;
import org.starlabs.utils.NameComparator;
import org.starlabs.utils.SalaryComparator;

@WebServlet("/Employee_SelectAll")
public class Employee_SelectAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter out;
	Connection con;
	Statement st;
	List list;

	public Employee_SelectAll() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	public void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			out = res.getWriter();

			con = ConnectionFactory.getConnection("employedb");
			st = con.createStatement();
			String query = "select * from employe order by id";
			ResultSet rs = st.executeQuery(query);
			List<Employee> listofEmp = new ArrayList<Employee>();
			while (rs.next()) {
				Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getString(5));
				listofEmp.add(emp);
			}
			String sortType = req.getParameter ("sort");
			if(sortType!=null){
			switch (sortType){
			default:break;
			case "byname":{
				Collections.sort(listofEmp, new NameComparator());
				break;}
			case "bysalary":{
				Collections.sort(listofEmp, new SalaryComparator());
				break;}
			}
			}
			req.setAttribute("empList", listofEmp);
			req.getRequestDispatcher("/Home.jsp").forward(req, res);
		} catch (SQLException | NullPointerException e){
			req.setAttribute("status", "No Connection to Database");
			req.getRequestDispatcher("/Home.jsp").forward(req, res);
			e.printStackTrace();
		}
			catch (Exception e) {
			System.out.println("Exception:" + e);
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
