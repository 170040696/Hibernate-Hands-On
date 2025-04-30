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

		SessionFactory sessionfactory=new Configuration().configure().addAnnotatedClass(telusko.class).buildSessionFactory();
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			 session=sessionfactory.openSession();
			 transaction=session.beginTransaction();
			 telusko t=new telusko();
			 t.setId(3);
			 t.setName("vyshnavi");
			 t.setCity("nellore");
			 
			//session.saveOrUpdate(t); //deprecated this method
			// session.merge(t);
			 
			// session.delete(t); //deprecated this method
			 session.remove(t);
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
