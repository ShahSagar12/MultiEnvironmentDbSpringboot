package com.sagar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sagar.dao.PersonRepository;

@Controller
public class PersonController {
	@Autowired
	private PersonRepository personRepository;

	@RequestMapping("/persons")
	public ResponseEntity<?> getPerson(){
		
		return ResponseEntity.ok(personRepository.findAll());
	}
}
