package com.nagarro.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nagarro.dao.ImageDao;

@WebServlet("/ImageRetrieveServlet")
public class ImageRetrieveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ImageDao iDao = new ImageDao();

		byte[] bAvatar = iDao.getImage(request);

		try {

			OutputStream sos = response.getOutputStream();
			sos.write(bAvatar);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
