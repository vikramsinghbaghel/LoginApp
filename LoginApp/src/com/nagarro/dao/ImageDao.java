package com.nagarro.dao;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;

import com.nagarro.entity.UserImages;
import com.nagarro.util.HibernateUtil;

public class ImageDao {

	public byte[] getImage(HttpServletRequest request) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		UserImages imgNew = (UserImages) session.get(UserImages.class,
				Integer.parseInt(request.getParameter("imageId")));

		byte[] bAvatar = imgNew.getImage();

		session.getTransaction().commit();
		return bAvatar;
	}

}
