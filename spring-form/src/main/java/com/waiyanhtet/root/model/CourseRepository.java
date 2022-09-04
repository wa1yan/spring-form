package com.waiyanhtet.root.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.waiyanhtet.dto.Course;

@Service
@ApplicationScope
public class CourseRepository {

	private List<Course> courses;
	
	public CourseRepository() {
		courses = new ArrayList<>();
	}

	public List<Course> getCourses() {
		var spring = new Course(1,"Spring framework",300000);
		var angular =  new Course(2,"Angular framework",200000);
		var node =  new Course(3,"Node Js",400000);
		var flutter =  new Course(4,"Flutter",500000);
		courses = List.of(spring,angular, node, flutter);
		return courses;
	}

	public Course findById(int id) {
		return courses.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
	}
}
