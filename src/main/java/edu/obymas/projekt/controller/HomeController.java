package edu.obymas.projekt.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String loginPage(Locale locale, Model model) {
        return "login";
    }
     
    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String login(@RequestParam("userName") String userName,Model model) {
    	userService.createUser(userName);
        model.addAttribute("userName", userName);
        return "user";
    }
	
}

