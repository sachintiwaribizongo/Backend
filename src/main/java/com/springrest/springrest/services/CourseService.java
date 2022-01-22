package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Courses;

public interface CourseService {
 
	public List<Courses>getCourse();	
	public Courses getCourseById(long courseId); 
	public Courses AddCourses(Courses course);
	public Courses UpdateCourse(Courses course);
	public void deleteCourse(long parseLong);
}
