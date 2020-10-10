package com.blackboard.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackboard.model.Course;
import com.blackboard.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	CourseRepository courseRepository;
	
	public ArrayList<Course> getAllCourses(){
		return (ArrayList<Course>) courseRepository.findAll();
	}
	
}
