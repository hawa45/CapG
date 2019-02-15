package com.capg.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.dao.CitiesRepository;
import com.capg.dao.DivisionsRepository;
import com.capg.dao.RolesRepository;
import com.capg.dao.UsersRepository;
import com.capg.entities.City;
import com.capg.entities.Divisions;
import com.capg.entities.Users;

@RestController
@RequestMapping("/guest")
public class GuestRestController {

	@Autowired
	UsersRepository userRepository;
	@Autowired
	RolesRepository rolesRepository;
	@Autowired
	CitiesRepository citiesRepository;
	@Autowired
	DivisionsRepository divisionsRepository;

	/* Récupére la liste des divisions */
	@GetMapping(value = "/divisions")
	public List<Divisions> getAllDivisions() {
		return divisionsRepository.findAll();
	}

	/* Récupère la liste des villes */
	@GetMapping(value = "/city")
	public List<City> getAllCity() {
		return citiesRepository.findAll();
	}

	/* Inscription des users */
	@PostMapping(value = "/user")
	public ResponseEntity<?> save(@RequestBody Users user) {
		user.setRole(rolesRepository.findByNameRole("Association"));
		user.setCity(citiesRepository.findByName(user.getCity().getName()));
		user.setDivisions(divisionsRepository.findByName(user.getDivisions().getName()));
		user.setCreatedDate(LocalDateTime.now());
		return new ResponseEntity<Users>(userRepository.save(user), HttpStatus.CREATED);
	}

}
