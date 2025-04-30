package com.telusko.application;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.telusko.model.telusko;

public class LaunchfirstApp {
	
	public static void main(String[] args) {
	//Step 1: Configuration object
	Configuration confg=new Configuration();
	
	//step 2: configure hibernate.cfg.xml file to Configuration Object
	confg.configure();
	
	//step 3: Create SessionFactory object
	SessionFactory sessionFactory=confg.buildSessionFactory();
	
	//step 4: Get the session object from SessionFactory
	Session session=sessionFactory.openSession();
	
	//step 5: Begin the transaction within the Session
	Transaction transaction=session.beginTransaction();
	
	telusko t=new telusko();
	t.setId(1);
	t.setName("Akanksha");
	t.setCity("Ongole");
	
	
	//step 6: Perform operation
	session.save(t);
	
	//step 7: Performing Transaction operation
	transaction.commit();
	
	//step 8: Close the session
	session.close();
	
	
	}

}
