package com.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techm.beans.PersonDetails;
import com.techm.beans.User;
import com.techm.services.RegisterService;

@Controller("registerController")
@SessionAttributes("id")
public class RegisterController {
	
	@Autowired
	private RegisterService registerService;
	
		/**
	 * @return the registerService
	 */
	public RegisterService getRegisterService() {
		return registerService;
	}


	/**
	 * @param registerService the registerService to set
	 */
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}


		@RequestMapping(value={"/registers"})	
		public String saveRegisteredDetails(@ModelAttribute("user") User user,BindingResult result, Model model)
		{
			//ModelAndView model= new ModelAndView("person");
			//users save logic
			Long id = getRegisterService().saveRegistrationDetails(user);
			model.addAttribute("id",id);
			PersonDetails pd = new PersonDetails();
			model.addAttribute("persons", pd);
			return "person";
		}
}
