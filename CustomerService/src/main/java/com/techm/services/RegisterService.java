package com.techm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.beans.User;
import com.techm.dao.RegisterDAO;

@Service("registerService")
@Transactional
public class RegisterService {
	
	@Autowired
	private RegisterDAO registerDAO;
	
	/**
	 * @return the registerDAO
	 */
	public RegisterDAO getRegisterDAO() {
		return registerDAO;
	}

	/**
	 * @param registerDAO the registerDAO to set
	 */
	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}

	/**
	 * 
	 * @param user
	 * @return boolean
	 */
	public Long saveRegistrationDetails(User user)
	{
		
		return getRegisterDAO().saveRegistrationDetails(user);
	}

}
