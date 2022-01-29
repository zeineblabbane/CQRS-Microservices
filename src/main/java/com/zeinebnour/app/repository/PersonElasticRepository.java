package com.zeinebnour.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeinebnour.app.model.PersonElastic;

@Repository
public interface PersonElasticRepository extends CrudRepository<PersonElastic, String> {
}
