package com.zeinebnour.app.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeinebnour.app.model.Person;

@Repository
public interface PersonMongoRepository extends CrudRepository<Person, String> {
}
