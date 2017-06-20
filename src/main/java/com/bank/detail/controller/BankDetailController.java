package com.bank.detail.controller;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.detail.beans.RestResponse;
import com.bank.detail.service.BankDetailService;
import com.bank.detail.validator.BankDetailsValidator;
import com.bank.detail.validator.ValidatorHelper;

@RestController
@RequestMapping("/api/bankdetail")
public class BankDetailController {

	private final BankDetailService bankDetailService;
	private final BankDetailsValidator validator;
	private final ValidatorHelper helper;

	public BankDetailController(BankDetailsValidator validator, BankDetailService bankDetailService,
			ValidatorHelper helper) {
		this.validator = validator;
		this.bankDetailService = bankDetailService;
		this.helper = helper;
	}

	@RequestMapping(value = "/{blzcode}", method = RequestMethod.GET)
	public RestResponse getBankDetails(@PathVariable("blzcode") String code) throws Exception {
		BeanPropertyBindingResult result = new BeanPropertyBindingResult(code, "blzCode");
		validator.validate(code, result);
		if (result.hasErrors()) {
			return helper.prepareValidationError(result);
		}
		return bankDetailService.getBankDetails(code);
	}

}
