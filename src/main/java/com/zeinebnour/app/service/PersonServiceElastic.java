package com.zeinebnour.app.service;

import java.util.List;

import com.zeinebnour.app.model.PersonElastic;

public interface PersonServiceElastic {
	List<PersonElastic> findAll();
	PersonElastic findById(final String personId);
	PersonElastic save(final PersonElastic person);
	PersonElastic update(final PersonElastic person);
	void deleteById(final String personId);
}