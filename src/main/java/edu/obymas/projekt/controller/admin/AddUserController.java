package edu.obymas.projekt.controller.admin;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.PlayerService;
import edu.obymas.projekt.domain.service.RoleService;
import edu.obymas.projekt.domain.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AddUserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private RoleService roleService;
	
	private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);
	
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
    public ModelAndView showNewForm(Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("add-user");
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("userName") String userName,@ModelAttribute("password") String  password,
    		@ModelAttribute("role") String roleName, Locale locale, Model model) {
		
		User addedUser=userService.createUser(userName, password, roleName);
		
		if(addedUser.getRole().equals(roleService.loadRoleByRolename("Player"))) {
			playerService.createPlayer(addedUser.getId());
		}
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		return modelAndView;
    }
	
}