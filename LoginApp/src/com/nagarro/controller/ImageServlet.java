package com.nagarro.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.entity.UserImages;
import com.nagarro.util.HibernateUtil;

@WebServlet("/ImageServlet")
@MultipartConfig(maxFileSize = 162342)
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserImages myimage = new UserImages();
		myimage.setName(request.getParameter("name"));

		Part part = request.getPart("file");

		InputStream is = null;

		if (part != null) {

			is = part.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);

			myimage.setImage(data);

			Transaction tx = null;

			try {

				Session session = HibernateUtil.getSessionFactory().openSession();
				tx = session.beginTransaction();

				session.persist(myimage);

				tx.commit();

				System.out.println("Image Uploaded Successfully: ");
			} catch (Exception e) {

				System.out.println("Image uploading failed ");
			}

			response.sendRedirect("LoginSuccess.jsp ");
		}

	}

}
