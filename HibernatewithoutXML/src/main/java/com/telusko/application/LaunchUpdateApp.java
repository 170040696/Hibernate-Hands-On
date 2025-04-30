package com.telusko.application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.telusko;

public class LaunchUpdateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration config=new Configuration();
//		config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/jdbclearning");
//		config.setProperty("hibernate.connection.password", "@1Prasada");
//		config.setProperty("hibernate.connection.username", "root");
//		config.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//		config.setProperty("hibernate.hbm2ddl.auto", "update");
		
		SessionFactory sessionfactory=config.addAnnotatedClass(telusko.class).buildSessionFactory();
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			 session=sessionfactory.openSession();
			 transaction=session.beginTransaction(); 
			 telusko t=new telusko();
		     t.setTid(4);
		     t.setTname("pavani");
		     t.setTcity("benag");
			 
			//session.saveOrUpdate(t); //deprecated this method
			 session.merge(t);
			 
			// session.delete(t); //deprecated this method
			 //session.remove(t);
			 flag=true;
		}
		catch(HibernateException e) {
			e.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true)
				transaction.commit();
			else
				transaction.rollback();
			
			session.close();
			sessionfactory.close();
		}
	}

}
