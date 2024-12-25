package io.fijaoui.altenProject.service;

import io.fijaoui.altenProject.dto.LoginRequest;
import io.fijaoui.altenProject.dto.RegistrationRequest;
import io.fijaoui.altenProject.entities.User;
import io.fijaoui.altenProject.enums.AuthRoles;
import io.fijaoui.altenProject.repository.UserRepository;
import io.fijaoui.altenProject.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private  JwtTokenUtil jwtTokenUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public String login(LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		return jwtTokenUtil.generateToken(authentication);
	}

	@Override
	public void signIn(RegistrationRequest registrationRequest) {

		if (!registrationRequest.password().equals(registrationRequest.confirmPassword())) {
			throw new IllegalArgumentException("Passwords do not match.");
		}

		if (userRepository.existsByUsername(registrationRequest.username())) {
			throw new IllegalArgumentException("Username is already taken.");
		}


		User user = new User();
		user.setFullName(registrationRequest.fullName());
		user.setUsername(registrationRequest.username());
		user.setMail(registrationRequest.email());
		user.setRole(AuthRoles.USER);
		user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.password()));

		userRepository.save(user);

	}
}
