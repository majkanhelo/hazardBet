package edu.obymas.projekt.controller.admin;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/admin")
public class AddUserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);
	
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
    public ModelAndView showNewForm(Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("add-user");
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("userName") String userName,@ModelAttribute("password") String  password,
    		@ModelAttribute("role") String roleName, Locale locale, Model model) {
		
		userService.createUser(userName, password, roleName);
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		return modelAndView;
    }
	
}