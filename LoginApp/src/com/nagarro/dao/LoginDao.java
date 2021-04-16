package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.entity.LoginBean;
import com.nagarro.util.HibernateUtil;

public class LoginDao {

	public LoginBean getbean() {
		LoginBean loginbean = new LoginBean();

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		loginbean = (LoginBean) session.get(LoginBean.class, 1);
		txn.commit();
		return loginbean;
	}

}
