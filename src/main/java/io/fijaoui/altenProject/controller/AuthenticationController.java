package io.fijaoui.altenProject.controller;

import io.fijaoui.altenProject.dto.LoginRequest;
import io.fijaoui.altenProject.dto.RegistrationRequest;
import io.fijaoui.altenProject.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		return authService.login(loginRequest);
	}
	@PostMapping("/sign-in")
	public void signIn(@RequestBody RegistrationRequest registrationRequest) {
		authService.signIn(registrationRequest);
	}
}
