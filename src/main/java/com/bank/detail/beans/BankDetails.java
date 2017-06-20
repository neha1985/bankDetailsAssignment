package com.bank.detail.beans;

public class BankDetails {

	private String designation;
	private String bankIdentifierCode;
	private String place;
	private String postCode;

	public BankDetails(String designation, String bankIdentifierCode, String place, String postCode) {
		this.designation = designation;
		this.bankIdentifierCode = bankIdentifierCode;
		this.place = place;
		this.postCode = postCode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getBankIdentifierCode() {
		return bankIdentifierCode;
	}

	public void setBankIdentifierCode(String bankIdentifierCode) {
		this.bankIdentifierCode = bankIdentifierCode;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
