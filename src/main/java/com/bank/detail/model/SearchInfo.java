package com.bank.detail.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "search_info")
public class SearchInfo {

	private String blzCode;
	private String error;
	private String result;
	private Date createdOn;

	public SearchInfo(String blzCode, Date createdOn) {
		this.blzCode = blzCode;
		this.createdOn = createdOn;
	}

	public String getBlzCode() {
		return blzCode;
	}

	public void setBlzCode(String blzCode) {
		this.blzCode = blzCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "SearchInfo [blzCode=" + blzCode + ", error=" + error + ", result=" + result + ", createdOn=" + createdOn
				+ "]";
	}

}
