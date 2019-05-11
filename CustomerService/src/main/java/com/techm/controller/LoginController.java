package com.techm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.User;

@Controller
public class LoginController {
	
	@RequestMapping("/")
	public ModelAndView login()
	{
		ModelAndView model= new ModelAndView("login");
		User user = new User();
		model.addObject("user", user);
		return model;
	}
	
	@RequestMapping("/login")
	public ModelAndView getLoginDetails(@ModelAttribute("user") User user)
	{
		ModelAndView model= new ModelAndView("register");
		
		System.out.println(user.getEmail());
		
		return model;
	}

}
