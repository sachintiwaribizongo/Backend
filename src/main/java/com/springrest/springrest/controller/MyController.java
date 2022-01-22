package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Courses;
import com.springrest.springrest.services.CourseService;

@RestController	
public class MyController {
    @Autowired
	private CourseService courseservice;
	
	
	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}
	// get the all courses available
	 
	@GetMapping("/courses")
	 public List<Courses> getCourse(){
		  return this.courseservice.getCourse();
	 }
	
	//get course by id
	@GetMapping("/courses/{courseId}")
	public Courses getCourseById(@PathVariable String courseId) {
		return this.courseservice.getCourseById(Long.parseLong(courseId));
	}
	
	//add courses
	@PostMapping("/courses")
	public Courses AddCourses(@RequestBody Courses course ) {
		 return this.courseservice.AddCourses(course);
	}
	//update the course
	@PutMapping("/courses")
	public Courses UpdateCourse(@RequestBody Courses course) {
		return this.courseservice.UpdateCourse(course);
	}
	//Now deleting element
	@DeleteMapping("/courses/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
		try {
			this.courseservice.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
