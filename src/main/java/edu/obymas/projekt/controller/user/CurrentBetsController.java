package edu.obymas.projekt.controller.user;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.dao.implement.CurrentBetsDaoImpl;
import edu.obymas.projekt.domain.model.CurrentBet;
import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class CurrentBetsController {
	@Autowired
	private CurrentBetsDaoImpl currentBetsDao;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/currentBets", method = RequestMethod.GET)
    public ModelAndView showBetsHistory(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("user/current-bets");		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    User user=userService.loadUserByUsername(username);
	    
		List<CurrentBet> currentBets= currentBetsDao.getPlayerCurrentBets(user.getId());
		model.addAttribute("currentBets",currentBets);

		return modelAndView;
	}
}
