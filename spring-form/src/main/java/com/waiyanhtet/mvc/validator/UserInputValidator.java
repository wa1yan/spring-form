package com.waiyanhtet.mvc.validator;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.waiyanhtet.dto.UserInput;

@Configuration
public class UserInputValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserInput.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(target instanceof UserInput input) {
			/*
			 * if(isEmptyString(input.getName())) { errors.rejectValue("name", "empty",
			 * "Enter user name"); }
			 */
			
			if(isEmptyString(input.getPhone())) {
				errors.rejectValue("phone", "empty", "Enter phone number if you have phone number");
			}
			
			if(isEmptyString(input.getEmail())) {
				errors.rejectValue("email", "empty", "Enter email address if you have email");
			}
			
			/*
			 * if(isEmptyString(input.getPassword())) { errors.rejectValue("password",
			 * "empty", "Enter password"); }
			 * 
			 * if(null == input.getCourse()) { errors.rejectValue("course", "no_select",
			 * "Choose course"); }
			 * 
			 * if(null == input.getGender()) { errors.rejectValue("gender", "empty",
			 * "Choose your gender"); }
			 * 
			 * if(input.getFoundations().length < 1 ) { errors.rejectValue("foundations",
			 * "no_choose", "Choose your knowledges"); }
			 * 
			 * if(input.isAgree() == false) { errors.rejectValue("agree", "no_choose",
			 * "Check agree"); }
			 */
		}
		
	}
	
	private boolean isEmptyString(String param) {
		return !StringUtils.hasLength(param);
	}

}
