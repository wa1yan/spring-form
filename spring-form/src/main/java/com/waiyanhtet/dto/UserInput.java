package com.waiyanhtet.dto;

import java.time.LocalDate;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.waiyanhtet.mvc.validator.Phone;

import lombok.Data;

@Data
public class UserInput {

	private int id;

	@NotBlank(message = "{empty.employee.name}")
	private String name;
	
	@Phone(message = "{invalid.phone.no}")
	private String phone;
	
	@Email(message = "{empty.email}")
	private String email;
	
	@NotBlank(message = "{empty.password}")
	private String password;
	
	@NotNull(message = "Select Course")
	private Course course;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate registration;
	private Gender gender;
	private String[] foundations;
	
	@AssertTrue(message = "You must to agree")
	private boolean agree;
	private String remark;
	
	public enum Gender {
		Male, Female
	}
}
