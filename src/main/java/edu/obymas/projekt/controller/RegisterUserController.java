package edu.obymas.projekt.controller;

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

import edu.obymas.projekt.controller.admin.AddUserController;
import edu.obymas.projekt.domain.dao.implement.TeamDaoImpl;
import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.PlayerService;
import edu.obymas.projekt.domain.service.RoleService;
import edu.obymas.projekt.domain.service.UserService;

@Controller
public class RegisterUserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private RoleService roleService;
	
	private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showNewForm(Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("register");
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("userName") String userName,@ModelAttribute("password") String  password,
    	 Locale locale, Model model) {
		
		User addedUser=userService.createUser(userName, password, "Player");
		
		playerService.createPlayer(addedUser.getId());
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		return "redirect:/";
    }
	
}