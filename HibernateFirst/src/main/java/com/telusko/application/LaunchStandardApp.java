package com.telusko.application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.telusko;

public class LaunchStandardApp {
	
	public static void main(String[]args) {
		
		Configuration config= null;
		SessionFactory sessionfactory=null;
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		
		config=new Configuration();
		config.configure();
		sessionfactory=config.buildSessionFactory();
		session=sessionfactory.openSession();
		
		telusko t=new telusko();
		t.setId(2);
		t.setName("Prasada");
		t.setCity("Hyd");
		
		try {
			transaction=session.beginTransaction();
			session.persist(t);
			flag=true;
		}
		catch(HibernateException e) {
		e.printStackTrace();	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag==true) {
				transaction.commit();
			}
			else {
				transaction.rollback();
			}
			session.close();
			sessionfactory.close();
		}
	}

}
