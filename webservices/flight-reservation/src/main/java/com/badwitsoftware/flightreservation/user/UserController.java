package com.badwitsoftware.flightreservation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServiceImpl userService;

	private static final String LOGIN_VIEW = "login/login";
	private static final String REGISTRATION_VIEW = "login/registerUser";

	@RequestMapping("/showRegister")
	public String showRegistrationPage() {
		return REGISTRATION_VIEW;
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") UserDto user) {
		userService.save(user);
		return LOGIN_VIEW;
	}

	@RequestMapping("/showLogin")
	public String showLoginPage() {
		return LOGIN_VIEW;
	}

	@PostMapping("/signin")
	public String signin(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {

		if (userService.login(email, password)) {
			return "findFlights";
		} else {
			modelMap.addAttribute("loginMessage", "Invalid username or password. Please try again.");
			return LOGIN_VIEW;
		}
	}

}
