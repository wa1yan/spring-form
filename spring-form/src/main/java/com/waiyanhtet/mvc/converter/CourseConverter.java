package com.waiyanhtet.mvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.waiyanhtet.dto.Course;
import com.waiyanhtet.root.model.CourseRepository;

@Component
public class CourseConverter implements Converter<String, Course> {

	@Autowired
	private CourseRepository repo;

	@Override
	public Course convert(String value) {
		if (StringUtils.hasLength(value)) {
			return repo.findById(Integer.parseInt(value));
		}
		return null;
	}

}
