package com.estsoft.blogjpa.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
	private Long id;
	private String name;
	private int age;
	private List<String> hobbies;
}
