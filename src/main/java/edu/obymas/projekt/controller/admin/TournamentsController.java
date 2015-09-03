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

import edu.obymas.projekt.domain.dao.implement.TournamentDaoImpl;
import edu.obymas.projekt.domain.dao.implement.TournamentTeamDaoImpl;
import edu.obymas.projekt.domain.model.Team;
import edu.obymas.projekt.domain.model.Tournament;
import edu.obymas.projekt.domain.model.User;

@Controller
@RequestMapping(value = "/admin")
public class TournamentsController {
	
	@Autowired
	private TournamentDaoImpl tournamentDao;
	
	@Autowired
	private TournamentTeamDaoImpl tournamentTeamDao;
	
	@RequestMapping(value = "/tournaments", method = RequestMethod.GET)
    public ModelAndView showForm(Locale locale, Model model) {
		
		List<Tournament> allTournaments=tournamentDao.getAllTournaments();
		
		ModelAndView modelAndView = new ModelAndView("admin/list-of-tournaments");
		model.addAttribute("tournaments", allTournaments);
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/tournament/{tournamentId} ", method = RequestMethod.GET)
    public ModelAndView showTournamentsTeam(@PathVariable String tournamentId,Locale locale, Model model) {
		
		List<Team> allTeams=tournamentDao.getAllTeamInTournament(Long.parseLong(tournamentId));
		List<Team> teamsNotIn=tournamentDao.getAllTeamNotInTournament(Long.parseLong(tournamentId));
		Tournament currentTournament=tournamentDao.find(Long.parseLong(tournamentId));
		
		ModelAndView modelAndView = new ModelAndView("admin/list-of-teams");
		model.addAttribute("teams", allTeams);
		model.addAttribute("notInTeams", teamsNotIn);
		model.addAttribute("tournament", currentTournament.getName());
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/tournament/{tournamentId}/deleteTeam", method = RequestMethod.POST)
    public String deleteTeam(@PathVariable String tournamentId, @ModelAttribute("teamId") long teamId,
    		Locale locale, Model model) {
		
		tournamentTeamDao.deleteTeamFromTournament(Long.parseLong(tournamentId), teamId);
		String redirectUrl = "/admin/tournament/"+tournamentId;
	    return "redirect:" + redirectUrl;
    }
	
	@RequestMapping(value = "/tournament/{tournamentId}/addTeam ", method = RequestMethod.POST)
    public String addTeam(@PathVariable String tournamentId, @ModelAttribute("newTeam") long teamId,
    		Locale locale, Model model) {
		
		tournamentTeamDao.addTeamToTournament(Long.parseLong(tournamentId), teamId);
		String redirectUrl = "/admin/tournament/"+tournamentId;
	    return "redirect:" + redirectUrl;
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
