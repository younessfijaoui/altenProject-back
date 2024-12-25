package io.fijaoui.altenProject.entities;

import io.fijaoui.altenProject.enums.AuthRoles;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue
	private Long idUser;

	private String fullName;

	@Column(unique = true)
	private String username;

	private String password;

	@Column(unique = true)
	private String mail;

	@Enumerated(EnumType.STRING)
	private AuthRoles role;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Basket basket;
}
