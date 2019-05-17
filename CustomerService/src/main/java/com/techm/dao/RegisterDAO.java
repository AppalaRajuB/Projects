package com.techm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techm.beans.User;

public class RegisterDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	public Long saveRegistrationDetails(User user) {
		
		Long id = 0L;
		Session session = null;
		Transaction tx  = null;
		try
		{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();
			id = user.getId();
		}catch(Exception ex)
		{
			tx.rollback();
		}finally
		{
			session.close();
		}
		
		return id;
	}

}
