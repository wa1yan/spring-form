package com.waiyanhtet.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class PhoneConstraint implements ConstraintValidator<Phone, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.hasLength(value)) {
			var pattern = "09(-\\d{4}-\\d{4}-\\d{2})";
			if(value.matches(pattern)) {
				return true;
			}
		}
		return true;
	}

}
