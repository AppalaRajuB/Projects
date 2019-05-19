/**
 * 
 */
package com.techm.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techm.beans.User;
import com.techm.dao.HomeDAO;

/**
 * @author BR00619160
 *
 */
@Service("homeService")
@Transactional
public class HomeService {
	
	@Autowired
	private HomeDAO homeDAO;

	/**
	 * @return the homeDAO
	 */
	public HomeDAO getHomeDAO() {
		return homeDAO;
	}

	/**
	 * @param homeDAO the homeDAO to set
	 */
	public void setHomeDAO(HomeDAO homeDAO) {
		this.homeDAO = homeDAO;
	}
	
	public List<User> getAllUsers()
	{
		return getHomeDAO().getAllUsers();
	}
	
	public User getUserDetails(Long id)
	{
		return getHomeDAO().getUserDetails(id);
	}
	
	public boolean savePersonalDetails(User user)
	{
		return getHomeDAO().savePersonalDetails(user);
	}
	
	public Map<String,String> getTotalUsersbyDay(String charttype)
	{
		return getHomeDAO().getTotalUsersbyDay(charttype);
	}
	
}
