package helloworld.hellospring.controller;

import java.util.List;


public class PersonTest {

		public static void main(String[] args){
			Person person = new Person();
			person.setId(123L);
			person.setName("Anything");
			person.setAge(20);
			person.setHobbies(List.of("줄넘기", "달리기"));

			System.out.println(person.getId());
			person.getName();
			person.getAge();
			person.getHobbies();
		}

}