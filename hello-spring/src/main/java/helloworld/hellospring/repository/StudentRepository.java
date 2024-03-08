package helloworld.hellospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import helloworld.hellospring.domain.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	Optional<Student> findByName(String name);

}
