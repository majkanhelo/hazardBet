package edu.obymas.projekt.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.model.Role;
import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.model.UserStatus;
import edu.obymas.projekt.domain.service.RoleService;
import edu.obymas.projekt.domain.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage(Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		return modelAndView;
    }
    
	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public String addUser(Locale locale, Model model) {

//    	ModelAndView modelAndView = new ModelAndView("add-user");
//    	modelAndView.addObject("user", new User());
//    	
//      return modelAndView;
		
		return "add-user";
	}
    
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addingUser(@RequestParam("userName") String userName, 
    		@RequestParam("userPassword") String userPassword, 
    		Model model) {
    	
//    	userService.createUser(userName, userPassword);
        model.addAttribute("userName", userName);
        
        return "list-of-users";
    }
    
    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public ModelAndView editUser(Locale locale, Model model) {
		
		User user = userService.getUser(1L);
		
		ModelAndView modelAndView = new ModelAndView("edit-user");
		modelAndView.addObject("user", user);
		
		return modelAndView;
//        return "login";
    }
    
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String editingUser(@RequestParam("userName") String userName, 
    		@RequestParam("userPassword") String userPassword,
    		@RequestParam("roleName") String roleName,
    		@RequestParam("userStatus") String userStatus,
    		Model model) {
    	
    	User user = userService.loadUserByUsername(userName);
    	Role role = roleService.loadRoleByRolename(roleName);
    	
    	user.setLogin(userName);
    	user.setPassword(userPassword);
    	user.setRole(role);
    	if("ACTIVE".equals(userStatus)) {
    		user.setStatus(UserStatus.ACTIVE);
    	} else {
    		user.setStatus(UserStatus.INACTIVE);
    	}
    	
    	userService.updateUser(user);
//        model.addAttribute("userName", userName);
        
        return "list-of-users";
    }
	
	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//    public String loginPage(Locale locale, Model model) {
//        return "login";
//    }
//     
//    @RequestMapping(value = "/home", method = RequestMethod.POST)
//    public String login(@RequestParam("userName") String userName,Model model) {
//    	  userService.createUser(userName);
//        model.addAttribute("userName", userName);
//        return "user";
//    }
	
}

