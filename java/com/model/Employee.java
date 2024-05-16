package com.model;

public class Employee {
	public String firstName;
	public String lastName;
	public String userName;
	public String password;
	public String confirmPassword;
	public String email;
	public String phoneNo;
	public String gender;
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", password="
				+ password + ", confirmPassword=" + confirmPassword + ", email=" + email + ", phoneNo=" + phoneNo
				+ ", gender=" + gender + ", getPhoneNo()=" + getPhoneNo() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getConfirmPassword()=" + getConfirmPassword() + ", getEmail()=" + getEmail()
				+ ", getGender()=" + getGender() + "]";
	}


	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Employee(String firstName, String lastName, String userName, String password, String confirmPassword,
			String email,String phoneNo, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.email = email;
		this.gender = gender;
		this.phoneNo = phoneNo;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
