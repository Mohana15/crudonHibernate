package com.federal.crudonhibernate;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App 
{
	
	public static void createdata() {
		
		Random r=new Random();
		
		
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentRecord.class);
		
		SessionFactory sf=configuration.buildSessionFactory();
		
		Session session=sf.openSession();
		Transaction tx=session.beginTransaction();
		for(int i=1;i<=50;i++) {
			
			StudentRecord sr=new StudentRecord();
		
			sr.setSid(i);
			sr.setSname("name"+i);
			sr.setSmarks(r.nextInt(100));
			sr.setSaddress("address"+i);
			
			session.save(sr);
			}
		
		tx.commit();
		session.close();
		sf.close();
	}
	
	public static void loaddata() {
		
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentRecord.class);
		
		ServiceRegistry srb=new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		SessionFactory sf=configuration.buildSessionFactory(srb);
		
		//this is first session to get the datA from db
		Session session=sf.openSession();
		StudentRecord sr=(StudentRecord) session.load(StudentRecord.class,1);
		System.out.println(sr.toString());
//		StudentRecord sr1=(StudentRecord) session.load(StudentRecord.class,2);
//		System.out.println(sr1.toString());
		session.close();
		
		
//		this is another session to get the data from db
		Session session2=sf.openSession();
		StudentRecord sr2=(StudentRecord) session2.load(StudentRecord.class,1);
		System.out.println(sr2.toString());
		session.close();
		//sf.close();
//		
		
	}
	
	public static void updatadata() {
		Configuration configuration=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(StudentRecord.class);
		
		SessionFactory sf=configuration.buildSessionFactory();
		
		Session session=sf.openSession();
		StudentRecord sr=(StudentRecord) session.load(StudentRecord.class,1);
		sr.setSaddress("south about");
		Transaction tx=session.beginTransaction();
		
		session.update(sr);
		tx.commit();
		session.close();
		sf.close();
		
	}
	
	
	
	
    public static void main( String[] args )
    {
    	
    		createdata();
    		//loaddata();
    		//updatadata();
    }
    
}
