package com.badwitsoftware.flightreservation.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager autheticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private Pbkdf2PasswordEncoder passwordEncoder;

	boolean login(String username, String password) {
		UserDetails details = userDetailsService.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(details, password,
				details.getAuthorities());

		autheticationManager.authenticate(token);
		boolean authenticated = token.isAuthenticated();

		if (authenticated) {
			SecurityContextHolder.getContext().setAuthentication(token);
		}
		return authenticated;
	}

	User save(UserDto dto) {
		User user = userRepository.findByEmail(dto.getEmail());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setFirstName(dto.getFirstName());
		user.setLastName(dto.getLastName());
		return user;
	}
}
