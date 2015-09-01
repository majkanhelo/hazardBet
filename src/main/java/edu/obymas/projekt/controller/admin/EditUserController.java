package edu.obymas.projekt.controller.admin;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EditUserController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(EditUserController.class);
	
	@RequestMapping(value = "/admin/editUser/{userId}", method = RequestMethod.GET)
    public ModelAndView showLoadedForm(@PathVariable String userId,Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("edit-user");
		
		User editedUser=userService.getUser(Long.parseLong(userId));
		
		model.addAttribute("userName", editedUser.getLogin());
		model.addAttribute("password", editedUser.getPassword());
		model.addAttribute("role",editedUser.getRole().getName());
		model.addAttribute("id", editedUser.getId());
		
		return modelAndView;
    }
	
	
	@RequestMapping(value = "/admin/editUser/{userId}", method = RequestMethod.POST)
    public ModelAndView onSubmit(@PathVariable String userId,@ModelAttribute("userName") String userName,@ModelAttribute("password") String  password,
    		@ModelAttribute("role") String roleName, Locale locale, Model model) {
		
		
		userService.updateUser(userName, password, roleName, Long.parseLong(userId));
		
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		return modelAndView;
    }
	
}