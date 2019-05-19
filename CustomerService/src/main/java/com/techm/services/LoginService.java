package com.techm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.beans.User;
import com.techm.dao.LoginDAO;

@Service("loginService")
@Transactional
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;
	
	
	/**
	 * @return the loginDAO
	 */
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}


	/**
	 * @param loginDAO the loginDAO to set
	 */
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public User verifyLogin(User user)
	{
		
		return getLoginDAO().verifyLogin(user);
	}
}
