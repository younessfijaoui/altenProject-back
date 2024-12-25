package io.fijaoui.altenProject.service;

import io.fijaoui.altenProject.dto.LoginRequest;
import io.fijaoui.altenProject.dto.RegistrationRequest;

public interface AuthService {

	String login(LoginRequest loginRequest);
	void signIn(RegistrationRequest registrationRequest);
}
