package com.model;

public class Registration {
	String name;
	String mailId;
	String phoneNumber;

	public Registration(String name, String mailId, String phoneNo) {
		super();
		this.name = name;
		this.mailId = mailId;
		this.phoneNumber = phoneNo;
	}

	public Registration() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Registration [name=" + name + ", mailId=" + mailId + ", phoneNumber=" + phoneNumber + ", getName()="
				+ getName() + ", getMailId()=" + getMailId() + ", getphoneNumber()=" + getphoneNumber() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getphoneNumber() {
		return phoneNumber;
	}

	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
