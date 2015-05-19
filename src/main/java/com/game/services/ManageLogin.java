package com.game.services;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;


public class ManageLogin {

	private static SessionFactory factory;
	@Autowired
	private static UserInfo user;

	public void populateDB(String setName, String setPass, String setEmail) {
		try{
	         //factory = new Configuration().configure().buildSessionFactory();
	    	  Configuration configuration = new Configuration().configure();
	    	  StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	    	  factory = configuration.buildSessionFactory(builder.build());
	    	  
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		UserInfo user = new UserInfo();
		user.setUserName(setName);
		user.setPassWord(setPass);
		user.setEmail(setEmail);
		
		session.save(user);
		tx.commit();
		session.close();

	}
	
	public static String getPassword(String name) {
		try{
	         //factory = new Configuration().configure().buildSessionFactory();
	    	  Configuration configuration = new Configuration().configure();
	    	  StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
	    	  factory = configuration.buildSessionFactory(builder.build());
	    	  
	      }catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
		Session session = factory.openSession();
		String hql = "SELECT passWord FROM UserInfo WHERE userName= :name";
		Query query = session.createQuery(hql);
		query.setParameter("name",name);
		List pass = query.list();
		String passWord = "";
		for (Iterator iterator = pass.iterator(); iterator.hasNext();){
			passWord = (String) iterator.next();
		}
		session.close();
		
		return passWord;
	}
}
