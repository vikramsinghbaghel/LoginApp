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

import com.nagarro.entity.MyImage;
import com.nagarro.util.HibernateUtil;

/**
 * Servlet implementation class ImageServlet
 */
@WebServlet("/ImageServlet")
@MultipartConfig(maxFileSize = 162342)
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Mark up point 1 : ");
		MyImage myimage=new MyImage();
		myimage.setName(request.getParameter("name"));
		Part part=request.getPart("file");
		InputStream is=null;
		System.out.println("Mark up point 2 : ");
	//	System.out.println(part+"   ");
		if(part!=null) {
			System.out.println("Mark up point 3 : ");
			 is=part.getInputStream();
			 byte [] data=new byte [is.available()];
			 is.read(data);
			 myimage.setImage(data);
			 System.out.println("Mark up point 4 : ");
			 Transaction tx= null;
			 
			 try {
				 System.out.println("Mark up point 5 : ");
				 Session session=HibernateUtil.getSessionFactory().openSession();
				 tx=session.beginTransaction();
				 System.out.println("Mark up point 6 : ");
				 session.persist(myimage);
				 tx.commit();
				// request.setAttribute("Message", "Image upload");
				 System.out.println("Image Uploaded Successfully: ");
			 }
			 catch(Exception e) {
				 //request.setAttribute("Message", "Image not upload : ");
				 System.out.println("Image uploading failed ");
			 }
			 response.sendRedirect("LoginSuccess.jsp ");
		}
		
	}

}
