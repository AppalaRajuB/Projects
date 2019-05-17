package com.techm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.beans.PersonDetails;
import com.techm.beans.User;
import com.techm.dao.PersonDAO;

@Service("personService")
@Transactional
public class PersonService {
	
	@Autowired
	private PersonDAO personDAO;
	

	/**
	 * @return the personDAO
	 */
	public PersonDAO getPersonDAO() {
		return personDAO;
	}


	/**
	 * @param personDAO the personDAO to set
	 */
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}


	/**
	 * 
	 * @param user
	 * @return boolean
	 */
	public boolean savePersonDetails(PersonDetails person,Long userid)
	{
		return getPersonDAO().savePersonDetails(person, userid);
	}

}
