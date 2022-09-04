package com.waiyanhtet.mvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.format.FormatterRegistry;

//@Configuration
public class CourseConverterRegistrator {

	//@Autowired
	//private CourseConverter converter; 
	
	@Autowired
	private CourseFormatter formatter; 
	
	@Autowired
	void addConverter(FormatterRegistry registry) {
		//registry.addConverter(converter);
		//registry.addFormatter(formatter);
		System.out.println("Formatter registration finished.");
	}
}
