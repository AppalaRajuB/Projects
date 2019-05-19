package com.techm.controller;


import java.sql.Timestamp;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.PersonDetails;
import com.techm.beans.User;
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
	public ModelAndView savePersonalDetails(@Valid @ModelAttribute("persons") PersonDetails persons,  @SessionAttribute("userobj") User userobj,BindingResult br)
	{
		ModelAndView model= null;
		 if(br.hasErrors())  
        {  
            return new ModelAndView("person");
        }  
        else  
        {  
			model= new ModelAndView("home");
			// To display user name  in home page.
			userobj.setPersons(persons);
			Date dob = DateUtil.getDateFormat(persons.getDateofBirth());
			Timestamp dobTS=new Timestamp(dob.getTime());
			persons.setDob(dobTS);
			getPersonService().savePersonDetails(persons, userobj.getId());
        }
		//model.addObject("users", user);
		return model;
	}

}
