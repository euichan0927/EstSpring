package helloworld.hellospring.service;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import helloworld.hellospring.controller.Person;
@Service
public class HelloService {
	public void parseProfile(String value) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			// json -> java object   : deSerialize
			Person person = objectMapper.readValue(value, Person.class);
			System.out.println("person = " + person);
		} catch (JsonProcessingException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("value=" + value);
	}
}
