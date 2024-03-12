package com.estsoft.blogjpa.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.estsoft.blogjpa.domain.Person;



@Controller
public class PageController {
	@GetMapping("/thymeleaf/example")
	public String thymeleafExample(Model model){
		Person person = new Person();
		person.setId(1L);
		person.setName("김의찬");
		person.setAge(26);
		person.setHobbies(List.of("헬스","음악감상"));

		model.addAttribute("person",person);
		model.addAttribute("today", LocalDateTime.now());

		return "examplePage";
	}
}
