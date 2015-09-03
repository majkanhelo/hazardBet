package edu.obymas.projekt.controller.admin;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.obymas.projekt.domain.dao.implement.TeamDaoImpl;
import edu.obymas.projekt.domain.model.User;

@Controller
@RequestMapping(value = "/admin")
public class AddTeamController {
	
	@Autowired
	private TeamDaoImpl teamDao;
	
	@RequestMapping(value = "/addTeam", method = RequestMethod.GET)
    public ModelAndView showNewForm(Locale locale, Model model) {
		
		ModelAndView modelAndView = new ModelAndView("admin/add-team");
		
		return modelAndView;
    }
	
	@RequestMapping(value = "/addTeam", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("teamName") String teamName, Locale locale, Model model) {
		
		teamDao.crateTeam(teamName);
		
		ModelAndView modelAndView = new ModelAndView("home");
		
		return modelAndView;
    }
	
}
