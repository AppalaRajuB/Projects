package com.techm.dao;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.techm.beans.User;

@Repository
public class HomeDAO {
	
private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@SuppressWarnings("unchecked")
	public List<User> getAllUsers()
	{
		List<User> usersList = null;
		Session session = null;
		try
		{
			session = this.sessionFactory.openSession();
			Query query = session.createQuery("from User");
			usersList= query.list();
		}catch(Exception ex)
		{
			ex.getMessage();
		}finally
		{
			session.close();
		}
		
		return usersList;
	}
	
	public User getUserDetails(Long id)
	{
		User user = null;
		Session session = null;
		try
		{
			session = this.sessionFactory.openSession();
			user = (User)session.get(User.class,id);
		}catch(Exception ex)
		{
			ex.getMessage();
		}finally
		{
			session.close();
		}
		return user;
	}
	
	public boolean savePersonalDetails(User user)
	{
		Session session = null;
		Transaction tx = null;
		boolean isSucess = false;
		try
		{
			session = this.sessionFactory.openSession();
			tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			isSucess = true;
		}catch(Exception ex)
		{
			ex.getMessage();
			tx.rollback();
		}finally
		{
			session.close();
		}
		
		return isSucess;
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,String> getTotalUsersbyDay(String charttype)
	{
		Session session = null;
		TreeMap<String,String> map = new TreeMap<String, String>();
		String queryString = "";
		if(charttype == null || charttype.equals("daily"))
		{
			queryString ="select TO_CHAR(p.createdate, 'dd/mm/yyyy') as d, count(*) as total " + 
					"from personal_details p " + 
					"  group by 1 order by 1";
		}else
		{
			queryString ="select TO_CHAR(p.createdate, 'Month') as m, count(*) as total "+
					"from personal_details p group by 1 order by 1";
		}
		
		try
		{
			session = this.sessionFactory.openSession();
			SQLQuery query = session.createSQLQuery(queryString);
			List<Object[]> rows = query.list();
			for(Object[] row : rows){
				if(row[0] == null)
				{
					map.put(null, row[1].toString());   
				}else
				{
					map.put(row[0].toString(), row[1].toString());  
				}
			}
			
		}catch(Exception ex)
		{
			ex.getMessage();
		}finally
		{
			session.close();
		}
		return map;
	}
	
	
}
