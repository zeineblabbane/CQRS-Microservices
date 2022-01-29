package com.zeinebnour.app.service;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeinebnour.app.model.PersonElastic;
import com.zeinebnour.app.repository.PersonElasticRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonServiceElasticImpl implements PersonServiceElastic {
	private PersonElasticRepository personElasticRepository;

	public PersonServiceElasticImpl(PersonElasticRepository personElasticRepository) {
		this.personElasticRepository = personElasticRepository;
	}

	@Override
	public List<PersonElastic> findAll() {
		
		final List<PersonElastic> persons = new ArrayList<>();
		this.personElasticRepository.findAll().forEach(persons::add);
		
		return Collections.unmodifiableList(persons);
	}
	
	@Override
	public PersonElastic findById(String personId) {
		return this.personElasticRepository.findById(personId).orElseThrow(NoSuchElementException::new);
	}
	
	@Override
	public PersonElastic save(PersonElastic person) {
		return this.personElasticRepository.save(person);
	}
	
	@Override
	public PersonElastic update(PersonElastic person) {
		return this.personElasticRepository.save(person);
	}
	
	@Override
	public void deleteById(String personId) {
		this.personElasticRepository.deleteById(personId);
	}
}