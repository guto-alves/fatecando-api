package com.gutotech.fatecandoapi.model.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = GenderValidator.class)
@Documented
public @interface Gender {

	String message() default "Author is not allowed.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}