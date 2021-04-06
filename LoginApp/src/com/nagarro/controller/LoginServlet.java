package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.database.LoginDao;
import com.nagarro.entity.LoginBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginBean loginbean=new LoginBean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);
		
		LoginDao loginDao =new LoginDao();
		LoginBean lb=loginDao.loginbean();
		if(username.equals(lb.getUsername()) && password.equals(lb.getPassword())) {
			
			response.sendRedirect("LoginSuccess.jsp");
		}
		else {
			response.sendRedirect("Login.jsp");
		}
	}

}
