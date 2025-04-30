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
		Session session2=null;
		//Transaction transaction=null;   transaction is needed only when we are updating, deleting, inserting
		boolean flag=false;
		try {
			session=sessionfactory.openSession();
			session2=sessionfactory.openSession();
			telusko t=session.get(telusko.class, 2);
			System.out.println(t);
			telusko t1=session2.get(telusko.class, 2);
			System.out.println(t1);
			
			//telusko t=session.load(telusko.class, 1);
//			telusko t=session.getReference(telusko.class, 5 );
//			System.out.println("Id id :"+t.getId());
//
//			System.out.println("name id :"+t.getName());
//
//			System.out.println("city id :"+t.getCity());
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			
			session.close();
			sessionfactory.close();
		}
	}

}
