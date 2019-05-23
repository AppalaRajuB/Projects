package com.techm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
@SessionAttributes("userobj")
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
		public String saveRegisteredDetails(@Valid @ModelAttribute("user") User user,BindingResult br, Model model)
		{
			//ModelAndView model= new ModelAndView("person");
			//users save logic
			 if(br.hasErrors())  
	        {  
	            return "register";  
	        }  
	        else  
	        { 
	        	User usrDB = getRegisterService().verifyemailRegisterdDetails(user);
	        	if(usrDB != null)
    			{
	        		model.addAttribute("userexists", "User already exists.Please try with another email.");
	        		return "register";
    			}else
    			{
    				user.setEmail(user.getEmail().trim().toLowerCase());
    				
    				BCryptPasswordEncoder pswdEncrypt = new BCryptPasswordEncoder();
    				user.setPasswd(pswdEncrypt.encode(user.getPasswd()));
					Long id = getRegisterService().saveRegistrationDetails(user);
					User usrSess = new User();
					usrSess.setId(id);
					model.addAttribute("userobj", usrSess);
					//model.addAttribute("id",id);
					PersonDetails pd = new PersonDetails();
					model.addAttribute("persons", pd);
    			}
			
		    }
			 return "person";
		}
}
