package edu.obymas.projekt.controller.admin;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.dao.implement.BetDaoImpl;
import edu.obymas.projekt.domain.dao.implement.BetsToTakeDaoImpl;
import edu.obymas.projekt.domain.dao.implement.GameDaoImpl;
import edu.obymas.projekt.domain.model.BetToTake;
import edu.obymas.projekt.domain.model.Team;
import edu.obymas.projekt.domain.model.Tournament;

@Controller
@RequestMapping(value = "/admin")
public class ResolveController {
	@Autowired
	private BetsToTakeDaoImpl betsToTakeDao;
	
	@Autowired
	private BetDaoImpl betDao;
	
	@Autowired
	private GameDaoImpl gameDao;
	
	@RequestMapping(value = "/resolveGame", method = RequestMethod.GET)
    public ModelAndView showGameForm(Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("admin/bets-to-resolve");		
	    
		List<BetToTake> betsToTake= betsToTakeDao.getBetsToTake();
		model.addAttribute("betsToTake",betsToTake);

		return modelAndView;
		
    }
	
	@RequestMapping(value = "/resolve/{betId}", method = RequestMethod.GET)
    public ModelAndView showResolveForm(@PathVariable String betId,Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("admin/bet-resolve");		

		return modelAndView;
		
    }
	
	@RequestMapping(value = "/resolve/{betId}", method = RequestMethod.POST)
    public ModelAndView resolveForm(@PathVariable String betId,@ModelAttribute("Result") String result,
    		@ModelAttribute("Winner") int winner, Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("home");	
		
		gameDao.updateGame(Long.parseLong(betId), result, winner);
		betDao.updateBet(Long.parseLong(betId));
		return modelAndView;
		
    }

}
