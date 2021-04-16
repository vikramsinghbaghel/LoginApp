package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.dao.LoginDao;
import com.nagarro.entity.LoginBean;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		LoginDao lDao = new LoginDao();
		LoginBean loginbean = lDao.getbean();

		if (username.equals(loginbean.getUserName()) && password.equals(loginbean.getPassword())) {

			response.sendRedirect("LoginSuccess.jsp");
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

}
