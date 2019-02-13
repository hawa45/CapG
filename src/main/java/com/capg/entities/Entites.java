package com.capg.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Entites {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(AccessLevel.NONE)
	@Column(name = "entites_id")
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy="entites")
	private Set<Users> listusers = new HashSet<>();
	
	@OneToMany(mappedBy = "entites")
	private List<Projects> listProjects = new ArrayList<>();
			
	
	protected Entites () {}


	public Entites(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
	

}
