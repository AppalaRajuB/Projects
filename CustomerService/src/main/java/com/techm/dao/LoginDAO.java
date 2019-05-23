/**
 * 
 */
package com.techm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.techm.beans.User;

@Repository
public class LoginDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

@SuppressWarnings("unchecked")
public User verifyLogin(User user) {
		
		Session session = null;
		User usrDB = null;
		List<User> usrList = null;
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
