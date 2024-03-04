package helloworld.hellospring.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import helloworld.hellospring.service.HelloService;

@RestController
public class HelloController {
	@Autowired
	private HelloService helloService;
	@GetMapping("/api/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	@PostMapping("/api/hi")
	public void hi(@RequestBody String name) {

		helloService.parseProfile("김의찬");
	}
}
