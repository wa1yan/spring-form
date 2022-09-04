package com.waiyanhtet.mvc.converter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.waiyanhtet.dto.Course;
import com.waiyanhtet.root.model.CourseRepository;
@Component
public class CourseFormatter implements Formatter<Course>{

	@Autowired
	private CourseRepository repo;
	
	@Override
	public String print(Course object, Locale locale) {
		if(object != null) {
			return object.getName();
		}
		return null;
	}

	@Override
	public Course parse(String value, Locale locale) throws ParseException {
		if (StringUtils.hasLength(value)) {
			return repo.findById(Integer.parseInt(value));
		}
		return null;
	}

}
