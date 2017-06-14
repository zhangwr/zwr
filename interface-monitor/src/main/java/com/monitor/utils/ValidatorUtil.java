package com.monitor.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

/**
 * 
 * @author lenovo
 *
 */
public class ValidatorUtil {
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

	public static <T> Map<String, String> validate(T obj) {
		Map<String, String> errorMap = null;
		Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
		if (set != null && set.size() > 0) {
			errorMap = new HashMap<String, String>();
			String property = null;
			for (ConstraintViolation<T> cv : set) {
				property = cv.getPropertyPath().toString();
				String errorValue = errorMap.get(property);
				if (errorValue != null) {
					errorValue = errorValue + "," + cv.getMessage();
					errorMap.put(property, errorValue);
				} else {
					errorMap.put(property, cv.getMessage());
				}
			}
		}
		return errorMap;
	}

}