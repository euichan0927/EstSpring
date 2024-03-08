package helloworld.hellospring.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LectureCourseInfo {
	private String title;
	private Long lectureCourseId;
	private LocalDate from;
	private LocalDate to;
	private Integer capacity;
	private Integer registeredStudentCount;
}