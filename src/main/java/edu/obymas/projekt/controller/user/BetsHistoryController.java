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

import edu.obymas.projekt.domain.dao.implement.BetsHistoryDaoImpl;
import edu.obymas.projekt.domain.model.BetsHistory;
import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class BetsHistoryController {
	
	@Autowired
	private BetsHistoryDaoImpl betsHistoryDao;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/betsHistory", method = RequestMethod.GET)
    public ModelAndView showBetsHistory(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("user/bets-history");		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    User user=userService.loadUserByUsername(username);
	    
		List<BetsHistory> betsHistory= betsHistoryDao.getPlayerBetsHistory(user.getId());
		model.addAttribute("betsHistory",betsHistory);

		return modelAndView;
	}

}
