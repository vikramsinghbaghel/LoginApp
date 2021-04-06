package com.nagarro.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.entity.LoginBean;

public class LoginDao {
	
	public static LoginBean loginbean() {
	LoginBean login=new LoginBean();
	login.setUsername("vikram");
	login.setPassword("vikram");
	SessionFactory sessionfactory=new Configuration().configure().buildSessionFactory();
	Session session=sessionfactory.openSession();
	session.beginTransaction();
	session.save(login);
	session.getTransaction().commit();
	//session .close();
	
	login=null;
//	session=sessionfactory.openSession();
	session.beginTransaction();
	login=(LoginBean)session.get(LoginBean.class, "vikram");
	
	//System.out.println("The Login details are user are username "+login.getUsername()+" Password="+login.getPassword());
	
	return login;
	
	}
	
}
