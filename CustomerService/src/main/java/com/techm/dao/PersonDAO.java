package com.techm.dao;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.techm.beans.PersonDetails;
import com.techm.beans.User;

@Repository
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
			PersonDetails personDetails = new PersonDetails();
			personDetails.setName(person.getName());
			personDetails.setGender(person.getGender());
			personDetails.setDateofBirth(person.getDateofBirth());
			personDetails.setDob(person.getDob());
			personDetails.setCreatedDate(new Timestamp(new Date().getTime()));
			personDetails.setUpdateDate(new Timestamp(new Date().getTime()));
  		    session.saveOrUpdate(personDetails);
  		    
  		    User user = (User)session.get(User.class, userid);
		 	user.setPersons(personDetails);
		 	session.update(user);
		 	
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
