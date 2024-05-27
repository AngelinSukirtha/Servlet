package com.model;

public class Login {
	String userName;
	String email;

	public Login(String userName, String email) {
		super();
		this.userName = userName;
		this.email = email;
	}

	public Login() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Login [userName=" + userName + ", email=" + email + ", getUserName()=" + getUserName() + ", getEmail()="
				+ getEmail() + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
