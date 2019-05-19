package com.techm.controller;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.techm.beans.User;
import com.techm.services.HomeService;
import com.techm.util.FileModel;
@Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	ServletContext context;
	
	/**
	 * @return the homeService
	 */
	public HomeService getHomeService() {
		return homeService;
	}

	/**
	 * @param homeService the homeService to set
	 */
	public void setHomeService(HomeService homeService) {
		this.homeService = homeService;
	}

	@RequestMapping("/home")
	public ModelAndView login(@ModelAttribute("users") User user)
	{
		ModelAndView model= new ModelAndView("home");
		return model;
	}
	
	@RequestMapping("/allusers")
	public ModelAndView allUsers(@ModelAttribute("users") User user)
	{
		ModelAndView model= new ModelAndView("allusers");
		List<User> allRegUsers = getHomeService().getAllUsers();
		model.addObject("allRegUsers", allRegUsers);
		return model;
	}
	
	@RequestMapping("/personaldetails")
	public ModelAndView personalDetails(@ModelAttribute("users") User user)
	{
		ModelAndView model= new ModelAndView("perosnalDetails");
		List<User> allRegUsers = getHomeService().getAllUsers();
		model.addObject("allRegUsers", allRegUsers);
		return model;
	}
	
	@RequestMapping("/editPerson")
	public ModelAndView editDetails(@RequestParam("uid") Long uid)
	{
		ModelAndView model= new ModelAndView("editperson");
		User user = getHomeService().getUserDetails(uid);
		model.addObject("users", user);
		return model;
	}
	
	
	@PostMapping("/details")  
    public ModelAndView savePersonDetails(@ModelAttribute("users") User user, @Validated FileModel file, BindingResult result) throws Exception
	{  
		ModelAndView model= new ModelAndView("sucess");
		if (result.hasErrors()) {
	         return new ModelAndView("editPerson");
	      } else {
	    	 user.setEmail(user.getEmail().trim().toLowerCase());
	    	 user.getPersons().setFilename(file.getFile().getOriginalFilename());
	    	 user.getPersons().setUpdateDate(new Timestamp(new Date().getTime()));
	    	 boolean isSuccess = getHomeService().savePersonalDetails(user);
	    	 if(isSuccess)
	    	 {
		         MultipartFile multipartFile = file.getFile();
		         String uploadPath = context.getRealPath("/fileuploads") + File.separator;
		         FileCopyUtils.copy(file.getFile().getBytes(), new File(uploadPath+file.getFile().getOriginalFilename()));
		         String fileName = multipartFile.getOriginalFilename();
	    	 }
	      }
		return model;
    } 
	
	@GetMapping("/charts")
	public ModelAndView viewCharts(@ModelAttribute("users") User chartuser)
	{
		ModelAndView model= new ModelAndView("chart");
		String str = "";
		 StringJoiner joinNames = new StringJoiner(",", "[", "]");
		Map<String, String> totalUsers = getHomeService().getTotalUsersbyDay(chartuser.getCharttype());
		 for (Map.Entry<String,String> entry : totalUsers.entrySet()) 
		 {
			 str = "'"+ entry.getKey() + "'";
			 joinNames.add(str);
		 }
		model.addObject("day", joinNames.toString());
		model.addObject("usrs", totalUsers);
		model.addObject("users", chartuser);
		return model;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(@ModelAttribute("users") User user)
	{
		ModelAndView model= new ModelAndView("");
		return model;
	}
}
