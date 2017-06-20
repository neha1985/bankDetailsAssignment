package com.bank.detail.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class BankDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return String.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		String code = (String) target;
		if (!StringUtils.isNumeric(code)) {
			errors.reject("code.invalid");
		}		
	}
}
