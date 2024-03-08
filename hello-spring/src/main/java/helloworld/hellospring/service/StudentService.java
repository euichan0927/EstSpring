package helloworld.hellospring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import helloworld.hellospring.domain.Student;
import helloworld.hellospring.repository.StudentRepository;
import jakarta.transaction.Transactional;

@Service

public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	public Optional<Student> getStudentById(Long id){
		return studentRepository.findById(id);
	}

	public Optional<Student> getStudentByName(String name){
		return studentRepository.findByName(name);
	}

	public void saveStudent(String name){
		Student student = new Student(name);
		studentRepository.save(student);
	}

	public void deleteStudentByName(String name){
		Optional<Student> student = studentRepository.findByName(name);
		if(student.isPresent()) {
			studentRepository.delete(student.get());
		}
	}
}
