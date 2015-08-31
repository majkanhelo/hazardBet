package edu.obymas.projekt.controller.admin;

	import java.util.List;
	import java.util.Locale;

	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.servlet.ModelAndView;

	import edu.obymas.projekt.domain.model.User;
	import edu.obymas.projekt.domain.service.UserService;

	/**
	 * Handles requests for the application home page.
	 */
	@Controller
	public class UserListController {
		
		@Autowired
		private UserService userService;
		
		private static final Logger logger = LoggerFactory.getLogger(AddUserController.class);
		
		@RequestMapping(value = "/admin/userList", method = RequestMethod.GET)
	    public ModelAndView showForm(Locale locale, Model model) {
			
			List<User> allUsers=userService.getAllUsers();
			
			ModelAndView modelAndView = new ModelAndView("list-of-users");
			model.addAttribute("users", allUsers);
			
			return modelAndView;
	    }
		
		
			
	}
