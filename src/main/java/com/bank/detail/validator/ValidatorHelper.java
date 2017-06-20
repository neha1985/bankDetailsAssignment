package com.bank.detail.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;

import com.bank.detail.beans.ResponseItemType;
import com.bank.detail.beans.RestResponse;

@Component
public class ValidatorHelper {

	@Autowired
	@Qualifier("ValidationErrMessageSource")
	private MessageSource validationErrMessageSource;

	public RestResponse prepareValidationError(BeanPropertyBindingResult result) {
		StringBuilder errors = new StringBuilder();
		for (ObjectError error : result.getAllErrors()) {
			errors.append(
					validationErrMessageSource.getMessage(error.getCode(), null, LocaleContextHolder.getLocale()));
		}
		return new RestResponse(ResponseItemType.ERROR, errors.toString(), HttpStatus.OK);
	}
}
