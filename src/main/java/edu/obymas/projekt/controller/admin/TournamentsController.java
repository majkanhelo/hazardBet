package edu.obymas.projekt.controller.admin;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.dao.implement.TournamentDaoImpl;
import edu.obymas.projekt.domain.model.Tournament;
import edu.obymas.projekt.domain.model.User;

@Controller
@RequestMapping(value = "/admin")
public class TournamentsController {
	
	@Autowired
	private TournamentDaoImpl tournamentDao;
	
	@RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    public ModelAndView showForm(Locale locale, Model model) {
		
		List<Tournament> allTournaments=tournamentDao.getAllTournaments();
		
		ModelAndView modelAndView = new ModelAndView("admin/list-of-tournaments");
		model.addAttribute("tournaments", allTournaments);
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/addTournament", method = RequestMethod.GET)
    public ModelAndView showNewForm(Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("admin/add-tournament");
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/addTournament", method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("name") String name, Locale locale, Model model) {
		
		tournamentDao.crateTournament(name);
		
		String redirectUrl = "/admin/tournaments";
	    return "redirect:" + redirectUrl;
    }
	
}
