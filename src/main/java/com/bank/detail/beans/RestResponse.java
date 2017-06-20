package com.bank.detail.beans;

import org.springframework.http.HttpStatus;

public class RestResponse {

	private ResponseItemType responseType;

	private Object responseObject;

	private HttpStatus status;

	public RestResponse(ResponseItemType responseType, Object responseObject, HttpStatus status) {
		this.responseType = responseType;
		this.responseObject = responseObject;
		this.status = status;
	}

	public ResponseItemType getResponseType() {
		return responseType;
	}

	public void setResponseType(ResponseItemType responseType) {
		this.responseType = responseType;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
