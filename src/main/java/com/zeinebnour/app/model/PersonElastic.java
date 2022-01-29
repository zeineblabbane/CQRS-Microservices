package com.zeinebnour.app.model;

import java.io.Serializable;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Document(
		indexName = "persons",
		replicas = 2
	)
@AllArgsConstructor
@Data
@Builder
@Getter
public class PersonElastic  implements Serializable{
private static final long serialVersionUID = 1L;
	
	@Id
	public String personId;
	public String fname;
	public String lname;
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public PersonElastic() {
		super();
	}
}
