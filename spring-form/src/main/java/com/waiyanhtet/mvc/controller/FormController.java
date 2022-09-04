package com.waiyanhtet.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.FormatterRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.waiyanhtet.dto.Course;
import com.waiyanhtet.dto.UserInput;
import com.waiyanhtet.dto.UserInput.Gender;
import com.waiyanhtet.mvc.converter.CourseConverter;
import com.waiyanhtet.mvc.converter.CourseFormatter;
import com.waiyanhtet.mvc.validator.UserInputValidator;
import com.waiyanhtet.root.model.CourseRepository;
import com.waiyanhtet.root.model.DataHolder;

@Controller
@RequestMapping("form")
public class FormController {

	@Autowired
	private DataHolder repo;
	
	@Autowired
	private CourseRepository courses;
	
	//@Autowired
	private CourseConverter converter;
	
	@Autowired
	private CourseFormatter formatter;
	
	@Autowired
	private UserInputValidator userInputValidator;
	
	@InitBinder
	void init(WebDataBinder binder) {
		var conversionService = binder.getConversionService();
		if(conversionService instanceof FormatterRegistry registry) {
			registry.addFormatter(formatter);
			System.out.println("Formatter registration finished.");
		}
		binder.addValidators(userInputValidator);
	}
	
	@GetMapping
	public void index() {
		
	}
	
	@PostMapping
	public String create(@Validated @ModelAttribute("userInput") UserInput data, BindingResult result) {
		if(result.hasErrors()) {
			return "form";
		}
		
		repo.add(data);
		return "redirect:/form";
	}
	
	@ModelAttribute("list")
	List<UserInput> list() {
		System.out.println("list data loading.");
		return repo.getAllData();
	}
	
	@ModelAttribute("userInput")
	UserInput userInput() {
		System.out.println("userInput data loading.");
		return new UserInput();
	}
	
	@ModelAttribute("courses")
	List<Course> courses(){
		System.out.println("courses data loading.");
		return courses.getCourses();
	}
	
	@ModelAttribute("genders")
	Gender[] genders() {
		System.out.println("genders data loading.");
		return Gender.values();
	}
	
	@ModelAttribute("foundations")
	List<String> foundations(){
		System.out.println("foundations data loading.");
		return List.of("HTML", "CSS", "Javascript", "Database");
	}
}
