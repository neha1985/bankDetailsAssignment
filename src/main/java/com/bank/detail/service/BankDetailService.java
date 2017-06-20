package com.bank.detail.service;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.detail.WebClient;
import com.bank.detail.beans.BankDetails;
import com.bank.detail.beans.ResponseItemType;
import com.bank.detail.beans.RestResponse;
import com.bank.detail.model.SearchInfo;
import com.bank.detail.repositories.SearchInfoRepository;

@Service
public class BankDetailService {

	private static final String SUCCESSFUL = "found";

	private static final String UNSUCCESSFUL = "not found";

	private final WebClient soapWebClient;

	private final SearchInfoRepository repo;

	public BankDetailService(WebClient soapWebClient, SearchInfoRepository repo) {
		this.soapWebClient = soapWebClient;
		this.repo = repo;
	}

	@Transactional()
	public RestResponse getBankDetails(String blzCode) {
		BankDetails response = null;
		SearchInfo search = prepareSearchInfo(blzCode);
		HttpStatus status = HttpStatus.OK;
		try {
			response = soapWebClient.getBankDetails(blzCode);
			search.setResult(SUCCESSFUL);
		} catch (Exception e) {
			search.setError(e.getMessage());
			search.setResult(UNSUCCESSFUL);
			status = HttpStatus.NOT_FOUND;
		}
		repo.save(search);
		return new RestResponse(ResponseItemType.RESULT, response, status);
	}

	private SearchInfo prepareSearchInfo(String blzCode) {
		return new SearchInfo(blzCode, new Date());
	}
}
