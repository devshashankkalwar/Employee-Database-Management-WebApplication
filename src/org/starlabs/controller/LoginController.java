package org.starlabs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.starlabs.Users.User;
import org.starlabs.Users.ValidateUser;


@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User isUser = new ValidateUser().validateUser(email,password,request,response);
		if(isUser!=null){
			request.getSession().setAttribute("user", isUser);
			response.sendRedirect("Home.jsp");
		}else{
			response.sendRedirect("Login.jsp?msg="+"Not able to login Please check Username or Password");
		}
	}

}
