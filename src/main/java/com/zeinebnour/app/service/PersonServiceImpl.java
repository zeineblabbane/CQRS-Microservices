package com.zeinebnour.app.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeinebnour.app.model.Person;
import com.zeinebnour.app.repository.PersonMongoRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
	private PersonMongoRepository personMongoRepository;

	public PersonServiceImpl(PersonMongoRepository personMongoRepository) {
		this.personMongoRepository = personMongoRepository;
	}

	@Override
	public List<Person> findAll() {
		
		final List<Person> persons = new ArrayList<>();
		this.personMongoRepository.findAll().forEach(persons::add);
		
		return Collections.unmodifiableList(persons);
	}
	
	@Override
	public Person findById(String personId) {
		return this.personMongoRepository.findById(personId).orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public Person save(Person person) {
		return this.personMongoRepository.save(person);
	}
	
	@Override
	public Person update(Person person) {
		return this.personMongoRepository.save(person);
	}
	
	@Override
	public void deleteById(String personId) {
		this.personMongoRepository.deleteById(personId);
	}
}









