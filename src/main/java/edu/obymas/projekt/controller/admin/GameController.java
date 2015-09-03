package edu.obymas.projekt.controller.admin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import edu.obymas.projekt.domain.dao.implement.GameDaoImpl;
import edu.obymas.projekt.domain.dao.implement.TournamentDaoImpl;
import edu.obymas.projekt.domain.dao.implement.TournamentTeamDaoImpl;
import edu.obymas.projekt.domain.model.Game;
import edu.obymas.projekt.domain.model.Team;
import edu.obymas.projekt.domain.model.Tournament;
import edu.obymas.projekt.domain.model.User;

@Controller
@RequestMapping(value = "/admin/game")
public class GameController {
	
	@Autowired
	private TournamentDaoImpl tournamentDao;
	
	@Autowired
	private GameDaoImpl gameDao;
	
	@Autowired
	private BetDaoImpl betDao;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView showForm(Locale locale, Model model) {
		
		List<Tournament> allTournaments=tournamentDao.getAllTournaments();
		
		ModelAndView modelAndView = new ModelAndView("admin/game-add-tournaments");
		model.addAttribute("tournaments", allTournaments);
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/tournament/{tournamentId}", method = RequestMethod.GET)
    public ModelAndView showGameForm(@PathVariable String tournamentId, Locale locale, Model model) {
		
		List<Team> allTeams=tournamentDao.getAllTeamInTournament(Long.parseLong(tournamentId));
		Tournament currentTournament=tournamentDao.find(Long.parseLong(tournamentId));
		
		ModelAndView modelAndView = new ModelAndView("admin/add-game");
		model.addAttribute("teams", allTeams);
		model.addAttribute("tournament", currentTournament.getName());
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/tournament/{tournamentId}", method = RequestMethod.POST)
    public ModelAndView addGame(@PathVariable String tournamentId,
    		@ModelAttribute("homeTeam") long homeTeam,@ModelAttribute("guestTeam") long guestTeam,
    		@ModelAttribute("gameDate") String gameDate, @ModelAttribute("homeLoad") String homeLoad,
    		@ModelAttribute("guestLoad") String guestLoad, @ModelAttribute("drawLoad") String drawLoad,
    		Locale locale, Model model) {
	
		String homeLoadStr=homeLoad.toString();
		String guestLoadStr=guestLoad.toString();
		String drawLoadStr=drawLoad.toString();
		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		Date date=new Date();
		try {
			date = formatter.parse(gameDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Game game=gameDao.creatGame(Long.parseLong(tournamentId),homeTeam , guestTeam, date);
		betDao.creatBet(game.getId(), Double.parseDouble(homeLoadStr), Double.parseDouble(guestLoadStr), Double.parseDouble(drawLoadStr));
	
		ModelAndView modelAndView = new ModelAndView("home");
		
		
		return modelAndView;
    }
}
