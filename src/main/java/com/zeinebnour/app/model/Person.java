package com.zeinebnour.app.model;

import java.io.Serializable;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Builder
public final class Person  implements Serializable {
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
}
