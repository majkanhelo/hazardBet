package edu.obymas.projekt.controller.user;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.dao.implement.BetsToTakeDaoImpl;
import edu.obymas.projekt.domain.model.BetToTake;


@Controller
@RequestMapping(value = "/user")
public class BetToTakeController {
	
	@Autowired
	private BetsToTakeDaoImpl betsToTakeDao;
	
	@RequestMapping(value = "/betsToTake", method = RequestMethod.GET)
    public ModelAndView showBetsToTake(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("user/bets-to-take");		
	    
		List<BetToTake> betsToTake= betsToTakeDao.getBetsToTake();
		model.addAttribute("betsToTake",betsToTake);

		return modelAndView;
	}

}