package com.capg.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String LastName;
	private String email;
	private String password;
	private boolean isActive = true;
	private LocalDateTime createdDate = LocalDateTime.now();
	
	@ManyToOne
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "entites_id", nullable = false)
	private Entites entites;
	
	@ManyToOne
	@JoinColumn(name = "role_id", nullable = false)
	private Roles role;
	
	protected Users() {}

	public Users(Long id, String name, String lastName, String email, String password, City city, Entites entites,
			Roles role) {
		this.id = id;
		this.name = name;
		LastName = lastName;
		this.email = email;
		this.password = password;
		this.city = city;
		this.entites = entites;
		this.role = role;
	}
	
	
	
	
	
	

}
