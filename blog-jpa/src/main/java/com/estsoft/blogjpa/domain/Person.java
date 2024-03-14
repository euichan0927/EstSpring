package com.estsoft.blogjpa.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Person {
	@Id
	private Long id;
	private String name;
	private int age;
	// private List<String> hobbies;
}
