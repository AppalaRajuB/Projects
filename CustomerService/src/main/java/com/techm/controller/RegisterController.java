package com.techm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.User;

@Controller
public class RegisterController {

		@PostMapping("/registers")	
		public ModelAndView saveRegisteredDetails(@ModelAttribute("user") User user)
		{
			ModelAndView model= new ModelAndView("personalinfo");
			//users save logic
			
			User users = new User();
			model.addObject("users", users);
			return model;
		}
}
