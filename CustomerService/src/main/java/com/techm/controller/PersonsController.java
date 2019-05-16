package com.techm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.User;

@Controller
public class PersonsController {
	
	@PostMapping("/persons")	
	public ModelAndView savePersonalDetails(@ModelAttribute("users") User user)
	{
		
		ModelAndView model= new ModelAndView("home");
		//System.out.println("asdfasfda:"+user.getPersons().getDob());
		model.addObject("users", user);
		return model;
	}

}
