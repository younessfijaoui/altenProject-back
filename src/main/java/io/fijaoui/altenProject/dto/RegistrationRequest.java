package io.fijaoui.altenProject.dto;

public record RegistrationRequest (
String fullName, String username, String email, String password, String confirmPassword
){

}