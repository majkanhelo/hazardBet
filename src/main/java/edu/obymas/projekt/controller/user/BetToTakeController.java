package edu.obymas.projekt.controller.user;

import java.util.List;
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

import edu.obymas.projekt.domain.dao.implement.BetsToTakeDaoImpl;
import edu.obymas.projekt.domain.dao.implement.CouponDaoImpl;
import edu.obymas.projekt.domain.model.BetToTake;
import edu.obymas.projekt.domain.model.Coupon;
import edu.obymas.projekt.domain.model.Player;
import edu.obymas.projekt.domain.model.User;
import edu.obymas.projekt.domain.service.PlayerService;
import edu.obymas.projekt.domain.service.UserService;


@Controller
@RequestMapping(value = "/user")
public class BetToTakeController {
	
	@Autowired
	private BetsToTakeDaoImpl betsToTakeDao;
	
	@Autowired
	private CouponDaoImpl couponDao;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PlayerService playerService;
	
	@RequestMapping(value = "/betsToTake", method = RequestMethod.GET)
    public ModelAndView showBetsToTake(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("user/bets-to-take");		
	    
		List<BetToTake> betsToTake= betsToTakeDao.getBetsToTake();
		model.addAttribute("betsToTake",betsToTake);

		return modelAndView;
	}
	
	@RequestMapping(value = "/betsToTake/{gameId}", method = RequestMethod.GET)
    public ModelAndView showTakeBetForm(@PathVariable String gameId,Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("user/take-bet");		
	    
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
	    User currentUser=userService.loadUserByUsername(username);
		double playerAccount=playerService.getPlayerAccount(currentUser.getId());
		
		model.addAttribute("maxAccount",playerAccount);

		return modelAndView;
	}
	
	@RequestMapping(value = "/betsToTake/{gameId}", method = RequestMethod.POST)
    public String onSubmit(@PathVariable String gameId, @ModelAttribute("betCash") double betCash, 
    		@ModelAttribute("choice") String choice, Locale locale, Model model) {	
	    
		if(betCash>0) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    String username = auth.getName();
		    
		    User currentUser=userService.loadUserByUsername(username);
			
			double currentAccount=playerService.getPlayerAccount(currentUser.getId());
			playerService.updatePlayerAccount(currentUser.getId(), currentAccount-betCash);
			
			int betChoice=0;
			if(choice.equals("Home win")) 
				betChoice=1;
			else if(choice.equals("Guest win"))
				betChoice=2;
			else	
				betChoice=3;
			
			couponDao.create(new Coupon(Long.parseLong(gameId),currentUser.getId(),betChoice,betCash));
		}

		String redirectUrl = "";
	    return "redirect:" + redirectUrl;
	}

}