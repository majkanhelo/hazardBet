package edu.obymas.projekt.controller.user;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.dao.UserDao;
import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.PlayerService;
import edu.obymas.projekt.domain.service.UserService;
import edu.obymas.projekt.domain.service.implement.UserDetailsServiceImpl;

@Controller
@RequestMapping(value = "/user")
public class EditAccountController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PlayerService playerService;
	
	private User currentUser;

	@RequestMapping(value = "/editAccount", method = RequestMethod.GET)
    public ModelAndView showEditAccountForm(Locale locale, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
		
		ModelAndView modelAndView = new ModelAndView("user/edit-account");
		currentUser=userService.loadUserByUsername(username);
		double playerAccount=playerService.getPlayerAccount(currentUser.getId());
		
		model.addAttribute("password", currentUser.getPassword());
		model.addAttribute("account",playerAccount);
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/editAccount", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("password") String password,
    		@ModelAttribute("account") double account, Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		if(currentUser!=null) {
			currentUser.setPassword(password);
			userService.updateUser(currentUser);
			playerService.updatePlayerAccount(currentUser.getId(), account);
		}
		
		return modelAndView;
    }
	
}

