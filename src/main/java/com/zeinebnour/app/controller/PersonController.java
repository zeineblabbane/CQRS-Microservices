package com.zeinebnour.app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.zeinebnour.app.model.Person;
import com.zeinebnour.app.model.PersonElastic;
import com.zeinebnour.app.service.PersonService;
import com.zeinebnour.app.service.PersonServiceElastic;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = {"/persons"})
@RequiredArgsConstructor
public class PersonController {
	private PersonService personService;
	private PersonServiceElastic personServiceElastic;

	public PersonController(PersonService personService, PersonServiceElastic personServiceElastic) {
		this.personService = personService;
		this.personServiceElastic = personServiceElastic;
	}

	@GetMapping
	public ResponseEntity<List<PersonElastic>> findAll() {
		return new ResponseEntity<>(this.personServiceElastic.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/{personId}")
	public ResponseEntity<PersonElastic> findById(@PathVariable("personId") final String personId) {
		return new ResponseEntity<>(this.personServiceElastic.findById(personId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Person> save(@RequestBody final Person person) {
		PersonElastic myPersonElastic = new PersonElastic();
		myPersonElastic.personId = person.personId;
		myPersonElastic.fname = person.fname;
		myPersonElastic.lname = person.lname;
		this.personServiceElastic.save(myPersonElastic);
		return new ResponseEntity<>(this.personService.save(person), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Person> update(@RequestBody final Person person) {
		PersonElastic myPersonElastic = new PersonElastic();
		myPersonElastic.personId = person.personId;
		myPersonElastic.fname = person.fname;
		myPersonElastic.lname = person.lname;
		this.personServiceElastic.update(myPersonElastic);
		return new ResponseEntity<>(this.personService.update(person), HttpStatus.OK);
	}
	
	@DeleteMapping("/{personId}")
	public ResponseEntity<Person> deleteById(@PathVariable("personId") final String personId) {
		this.personServiceElastic.deleteById(personId);
		this.personService.deleteById(personId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}