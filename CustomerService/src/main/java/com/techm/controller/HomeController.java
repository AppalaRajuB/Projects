package com.techm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.User;
@Controller
public class HomeController {
	
	@RequestMapping("/home")
	public ModelAndView login(@ModelAttribute("users") User user)
	{
		ModelAndView model= new ModelAndView("home");
		return model;
	}
}
