package helloworld.hellospring.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import helloworld.hellospring.repository.StudentJdbcRepository;
import helloworld.hellospring.service.HelloService;
import jakarta.persistence.criteria.CriteriaBuilder;

@RestController
public class HelloController {
	@Autowired
	private HelloService helloService;
	@Autowired
	private StudentJdbcRepository studentJdbcRepository;
	@GetMapping("/api/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
	@PostMapping("/api/hi")
	public void hi(@RequestBody String name) {

		helloService.parseProfile("김의찬");
	}
	//학생 수 확인
	@GetMapping("/hello")
	public int hi(){
		return studentJdbcRepository.countOfStudent();
	}
	//학생 리스트 확인
	@GetMapping("hello/list")
	public List<String> getName(){
		return studentJdbcRepository.getStudentNameList();
	}
	// 새로운 학생 등록
	@PostMapping("hello/regist")
	public int saveStudent(@RequestParam Integer id, @RequestParam String name){
		return studentJdbcRepository.insertStudent(id,name);
	}
}
