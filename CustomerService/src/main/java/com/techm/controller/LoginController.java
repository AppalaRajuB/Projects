package com.techm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.User;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public ModelAndView login(@ModelAttribute("user") User user)
	{
		ModelAndView model= new ModelAndView("login");
		return model;
	}
	
	@RequestMapping("/register")
	public ModelAndView showRegistration()
	{
		ModelAndView model= new ModelAndView("register");	
		User user = new User();
		model.addObject("user", user);
		return model;
	}

}
