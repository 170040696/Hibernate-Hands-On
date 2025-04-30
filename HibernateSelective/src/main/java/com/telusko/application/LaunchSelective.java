package com.telusko.application;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.Employee;

public class LaunchSelective {
	public static void main(String[]args) {
		SessionFactory sessionfactory=  new Configuration().configure().addAnnotatedClass(Employee.class).buildSessionFactory();
		Session session=null;
		Transaction transaction=null;
		boolean flage=false;
		try {
			session=sessionfactory.openSession();
			transaction=session.beginTransaction();
			Employee e=new Employee();
			e.setId(1);
			e.setName("AKanksha");
			e.setAge(25);
			e.setCity("ongole");
			session.persist(e);
			flage=true;
			
		}
		catch(HibernateException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flage==true)
				transaction.commit();
			else
				transaction.rollback();
			
			session.close();
			sessionfactory.close();
		}
	}

}
