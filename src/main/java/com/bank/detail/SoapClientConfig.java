package com.bank.detail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapClientConfig {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.bank.detail.wsdl");
		return marshaller;
	}

	@Bean
	public WebClient bankClient(Jaxb2Marshaller marshaller) {
		WebClient client = new WebClient();
		client.setDefaultUri("http://www.thomas-bayer.com/axis2/services/BLZService?wsdl");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
}
