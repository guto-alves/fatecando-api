package com.gutotech.fatecandoapi.model.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<Gender, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return false;
	}

}
