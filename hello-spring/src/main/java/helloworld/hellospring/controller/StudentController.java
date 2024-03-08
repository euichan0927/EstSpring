package helloworld.hellospring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import helloworld.hellospring.domain.Student;
import helloworld.hellospring.service.StudentService;
import jakarta.transaction.Transactional;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("students")
	public List<Student> allStudent(){
		return studentService.getAllStudent();
	}
	@GetMapping("students/{id}")
	public Optional<Student> getStudent(@PathVariable Long id){
		return studentService.getStudentById(id);
	}
	@GetMapping("students/find/{name}")
	public Optional<Student> getStudentName(@PathVariable String name){
		return studentService.getStudentByName(name);
	}
	@PostMapping("students")
	public void saveStudent(@RequestParam String name){
		studentService.saveStudent(name);
		System.out.println(name);
	}
	@DeleteMapping("students")
	public void deleteStudent(@RequestParam String name){
		studentService.deleteStudentByName(name);
	}
}
