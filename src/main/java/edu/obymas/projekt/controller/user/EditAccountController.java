package edu.obymas.projekt.controller.user;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.PlayerService;
import edu.obymas.projekt.domain.service.UserService;

@Controller
public class EditAccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PlayerService playerService;

	@RequestMapping(value = "/user/editAccount/{userId}", method = RequestMethod.GET)
    public ModelAndView showEditAccountForm(@PathVariable String userId,Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("edit-account");
		
		User editedUser=userService.getUser(Long.parseLong(userId));
		double playerAccount=playerService.getPlayerAccount(Long.parseLong(userId));
		
		model.addAttribute("password", editedUser.getPassword());
		model.addAttribute("account",playerAccount);
		
		return modelAndView;
    }
	
}

