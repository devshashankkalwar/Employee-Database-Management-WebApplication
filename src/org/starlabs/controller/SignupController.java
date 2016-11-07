package org.starlabs.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.starlabs.Users.RegisterUser;

@WebServlet("/signup.do")
public class SignupController extends HttpServlet {

    public SignupController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String fName= request.getParameter("fName");
	String lName= request.getParameter("lName");
	String email= request.getParameter("email");
	String password= request.getParameter("password");
	String cnfpassword= request.getParameter("cnfpassword");
	String contact= request.getParameter("contact");
	String dob= request.getParameter("dob");
	String gender= request.getParameter("gender");
	if (password.equals(cnfpassword)){
		try{
		boolean isRegistered = new RegisterUser().registerUser(fName, lName, email, cnfpassword, contact, dob, gender);
		response.sendRedirect("Login.jsp?msg="+"Registration Successfully!! You can Login Now.");
		}catch(SQLIntegrityConstraintViolationException e){
			response.sendRedirect("signup.jsp?msg="+"The EMail is already registered");
		}catch(NullPointerException | SQLException e){
			response.sendRedirect("signup.jsp?msg="+"Connection Error or DataBase Error");
		}catch(Exception e){
			e.printStackTrace();
		}
	}else
		response.sendRedirect("signup.jsp?msg="+"Password donot match");
	}

}
