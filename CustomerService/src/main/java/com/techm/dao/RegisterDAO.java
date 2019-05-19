package com.techm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.techm.beans.User;
@Repository
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
			ex.getMessage();
			tx.rollback();
		}finally
		{
			//session.clear();
			session.close();
		}
		
		return id;
	}
	
	
	@SuppressWarnings("unchecked")
	public User verifyemailRegisterdDetails(User user) {
			
			Session session = null;
			List<User> usrList = null;
			User usrDB = null;
			try
			{
				session = this.sessionFactory.openSession();
				Query query = session.createQuery("from User usr where usr.email = :email")
						.setString("email", user.getEmail().trim().toLowerCase());						
				usrList = query.list();
				if(usrList != null && usrList.size() > 0)
				{
					usrDB = usrList.get(0);
				}
			}catch(Exception ex)
			{
				ex.getMessage();
			}finally
			{
				session.close();
			}
			
			return usrDB;
		}


}
