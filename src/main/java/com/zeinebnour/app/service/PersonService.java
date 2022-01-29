package com.zeinebnour.app.service;

import java.util.List;

import com.zeinebnour.app.model.Person;

public interface PersonService {
	List<Person> findAll();
	Person findById(final String personId);
	Person save(final Person person);
	Person update(final Person person);
	void deleteById(final String personId);
}
