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
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.User;
import com.techm.services.LoginService;

@Controller
@SessionAttributes("userobj")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	/**
	 * @return the loginService
	 */
	public LoginService getLoginService() {
		return loginService;
	}

	/**
	 * @param loginService the loginService to set
	 */
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/")
	public ModelAndView login(@ModelAttribute("user") User user)
	{
		ModelAndView model= new ModelAndView("login");
		return model;
	}
	
	@RequestMapping("/register")
	public String showRegistration(Model model)
	{
		User user = new User();
		model.addAttribute("user", user);
		return "register";
	}
	
	
	@RequestMapping("/login")
	public String verifyLogin(@Valid @ModelAttribute("user") User user, BindingResult br, Model model)
	{
		BCryptPasswordEncoder pswdEncrypt = new BCryptPasswordEncoder();
		User usrDB = null;
    	usrDB = getLoginService().verifyLogin(user);
    	if(usrDB == null)
		{
    		model.addAttribute("nouser", "Please verify your credentials.");
    		return "login";
		}else if(!pswdEncrypt.matches(user.getPasswd(), usrDB.getPasswd()))
		{
			model.addAttribute("nouser", "Please verify your credentials.");
    		return "login";
		}else
		{
			
			model.addAttribute("userobj", usrDB);
			model.addAttribute("user", usrDB);
		}
		return "home";
	}
	
	

}
