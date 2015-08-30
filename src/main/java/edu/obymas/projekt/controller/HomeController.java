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

import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage(Locale locale, Model model) {
		
		List<User> users = userService.getAllUsers();
		
		ModelAndView modelAndView = new ModelAndView("list-of-users");
		modelAndView.addObject("users", users);
		
		return modelAndView;
//        return "login";
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
    public String addingUser(@RequestParam("userName") String userName, Model model) {
    	
    	userService.createUser(userName);
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

