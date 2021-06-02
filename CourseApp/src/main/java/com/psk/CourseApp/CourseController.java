package com.psk.CourseApp;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository courseRepo;
	
	@GetMapping("/courses")
	public String getCourse() {
		return "All course";
	}
	
	@GetMapping("/allcourses")
	public List<Course> getAllCourses(){
		/*
		 * return Arrays.asList( new Course("100", "Maths", "author1"), new
		 * Course("101", "Chem", "author2"), new Course("102", "Physic", "author3"), new
		 * Course("103", "ML", "author4"), new Course("104", "DS", "author5") );
		 */
		return courseRepo.findAll();
	}
	
	@GetMapping("allcourses/{id}")
	public Optional<Course> getSpecificCourse(@PathVariable("id") BigInteger id) {
		return courseRepo.findById(id);
	}
	
	@PostMapping("/allcourses")
	public void saveCourse(@RequestBody Course course) {
		courseRepo.save(course);
	}
	
	@DeleteMapping(value = "allcourses/{id}")
	public void deleteCourse(@PathVariable BigInteger id) {
		courseRepo.deleteById(id);
	}
}
