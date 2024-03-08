// package helloworld.hellospring.controller;
//
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.*;
//
// import java.util.List;
// import java.util.Map;
//
// import helloworld.hellospring.dto.LectureCourseDetail;
// import helloworld.hellospring.dto.LectureCourseInfo;
// import helloworld.hellospring.service.LectureService;
//
// @RestController
// public class LectureController {
// 	@Autowired
// 	private LectureService lectureService;
//
// 	@GetMapping("/lecture")
// 	public List<LectureCourseInfo> getLecture() {
// 		return lectureService.getLectureCourseInfo();
// 	}
//
// 	@GetMapping("/lecture/details")
// 	public List<LectureCourseDetail> getListOfStudentName(@RequestParam Map<String, Object> params) {
// 		return lectureService.getLectureCourseDetails(params);
// 	}
// }