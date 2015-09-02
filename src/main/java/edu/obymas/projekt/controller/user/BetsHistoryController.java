package edu.obymas.projekt.controller.user;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.dao.implement.BetsHistoryDaoImpl;
import edu.obymas.projekt.domain.model.BetsHistory;

@Controller
@RequestMapping(value = "/user")
public class BetsHistoryController {
	
	@Autowired
	private BetsHistoryDaoImpl betsHistoryDao;
	
	@RequestMapping(value = "/betsHistory", method = RequestMethod.GET)
    public ModelAndView showEditAccountForm(Locale locale, Model model) {
		ModelAndView modelAndView = new ModelAndView("user/bets-history");		

		List<BetsHistory> betsHistory= betsHistoryDao.getPlayerBetsHistory();
		model.addAttribute("betsHistory",betsHistory);

		return modelAndView;
	}

}
