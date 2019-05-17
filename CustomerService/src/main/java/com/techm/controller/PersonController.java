package com.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.PersonDetails;
import com.techm.services.PersonService;
import com.techm.util.DateUtil;

@Controller
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	/**
	 * @return the personService
	 */
	public PersonService getPersonService() {
		return personService;
	}


	/**
	 * @param personService the personService to set
	 */
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}


	@RequestMapping("/personal")	
	public ModelAndView savePersonalDetails(@ModelAttribute("persons") PersonDetails persons,@SessionAttribute("id") Long userid)
	{
		ModelAndView model= new ModelAndView("home");
		persons.setDob(DateUtil.convertUtilToSql(DateUtil.getDateFormat(persons.getDateofBirth())));
		getPersonService().savePersonDetails(persons, userid);
		//model.addObject("users", user);
		return model;
	}

}
