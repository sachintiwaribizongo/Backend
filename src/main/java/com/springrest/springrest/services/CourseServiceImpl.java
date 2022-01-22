	package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Courses;

@Service
public class CourseServiceImpl implements CourseService {

	List<Courses> MyArray;
	public CourseServiceImpl() {
		MyArray=new ArrayList<>();
		MyArray.add(new Courses(144,"springboot course","this course is about springboot intro"));
		MyArray.add(new Courses(3030,"ReactJs Course","this course is about react intro"));
	} 
	@Override
	public List<Courses> getCourse() {
		  return MyArray;
	}
	@Override
	public Courses getCourseById(long courseId) {
		 Courses C=null;
		 for(Courses course:MyArray) {
			 if(course.getId()==courseId) {
				 C=course;break;
			 }
		 }
		 return C;
	}
	@Override
	public Courses AddCourses(Courses course) {
		 MyArray.add(course);
		 return course; 
	}
	@Override
	public Courses UpdateCourse(Courses course) {
		 for(Courses c:MyArray) {
			 if(c.getId()==course.getId()) {
				 c.setDescription(course.getDescription());
				 c.setTitle(course.getTitle());
			 }
		 }
		 return course;
	}
	@Override
	public void deleteCourse(long parseLong) {
		 MyArray=this.MyArray.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
	}

}
