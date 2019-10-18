package com.travelab.reservation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
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

	@GetMapping("/showRegister")
	public String showRegistrationPage() {
		return REGISTRATION_VIEW;
	}

	@PostMapping("/register")
	public String register(@ModelAttribute("user") UserRequest user) {
		userService.save(user);
		return LOGIN_VIEW;
	}

	@GetMapping("/showLogin")
	public String showLoginPage() {
		return LOGIN_VIEW;
	}

	@PostMapping("/signin")
	public String signin(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {

		if (userService.login(email, password)) {
			return "findFlights";
		}
		modelMap.addAttribute("loginMessage", "Invalid username or password. Please try again.");
		return LOGIN_VIEW;

	}

}
