package com.bank.detail;

import org.apache.commons.lang3.CharEncoding;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

	public MessageSourceConfig() {
		super();
	}

	@Bean(name = "ValidationErrMessageSource")
	public MessageSource getValidationErrMessageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setDefaultEncoding(CharEncoding.UTF_8);
		messageSource.setBasenames("classpath:validation_err_messages");
		return messageSource;
	}
}
