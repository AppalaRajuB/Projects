package com.techm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.techm.beans.PersonDetails;
import com.techm.beans.User;

public class PersonDAO {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	
	/**
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean savePersonDetails(PersonDetails person, Long userid) {
		
		boolean isSuccess = false;
		Session session = null;
		Transaction tx  = null;
		try
		{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			User usr = (User)session.get(User.class, userid);
			usr.setPersons(person);
			session.save(person);
			tx.commit();
			isSuccess = true;
		}catch(Exception ex)
		{
			tx.rollback();
		}finally
		{
			session.close();
		}
		
		return isSuccess;
	}

}
