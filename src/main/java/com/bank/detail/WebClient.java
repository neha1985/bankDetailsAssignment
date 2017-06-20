package com.bank.detail;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;

import com.bank.detail.beans.BankDetails;
import com.bank.detail.wsdl.DetailsType;
import com.bank.detail.wsdl.GetBankResponseType;
import com.bank.detail.wsdl.GetBankType;
import com.bank.detail.wsdl.ObjectFactory;

/**
 * Web Client to get bankdetails for given blzcode
 *
 */
public class WebClient extends WebServiceGatewaySupport {

	@SuppressWarnings("unchecked")
	public BankDetails getBankDetails(String code) throws Exception {
		ObjectFactory objectFactory = new ObjectFactory();
		GetBankType request = objectFactory.createGetBankType();
		request.setBlz(code);
		JAXBElement<GetBankType> req = objectFactory.createGetBank(request);
		BankDetails response = null;
		try {
			JAXBElement<GetBankResponseType> res = (JAXBElement<GetBankResponseType>) getWebServiceTemplate()
					.marshalSendAndReceive(req);
			DetailsType details = res.getValue().getDetails();
			response = new BankDetails(details.getBezeichnung(), details.getBic(), details.getOrt(), details.getPlz());
		} catch (SoapFaultClientException e) {
			throw new Exception(e.getFaultStringOrReason());
		}
		return response;
	}
}
